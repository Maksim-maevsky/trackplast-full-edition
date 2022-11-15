package com.truckplast.analyzer.service.file.impl;


import com.truckplast.analyzer.constant.ParserConstant;
import com.truckplast.analyzer.constant.PartStorageConstant;
import com.truckplast.analyzer.entity.FileInfo;
import com.truckplast.analyzer.entity.part.Brand;
import com.truckplast.analyzer.entity.part.Part;
import com.truckplast.analyzer.entity.part.PartInfo;
import com.truckplast.analyzer.entity.part.PartWarehouse;
import com.truckplast.analyzer.exeption_handler.exception.EmptyFileNotFoundException;
import com.truckplast.analyzer.exeption_handler.exception.WorkBookCreationIOException;
import com.truckplast.analyzer.exeption_handler.exception.WrongPartStorageKeyException;
import com.truckplast.analyzer.repository.BrandRepository;
import com.truckplast.analyzer.repository.FileInfoRepository;
import com.truckplast.analyzer.repository.PartInfoRepository;
import com.truckplast.analyzer.repository.PartRepository;
import com.truckplast.analyzer.service.file.FileParserService;
import com.truckplast.analyzer.util.FileUtil;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;


@Service
@Data
@Slf4j
@RequiredArgsConstructor
public class FileParserServiceImpl implements FileParserService {


    private final PartInfoRepository partInfoRepository;

    private final FileInfoRepository fileInfoRepository;

    private final PartRepository partRepository;

    private final BrandRepository brandRepository;


    @Value("${file.path}")
    private String filePath;

    @Transactional
    @Override
    public void parsAndSave(FileInfo fileInfo, UUID mailInfoId) {

        log.info("Try to pars MailInfo");

        parsFileInfos(fileInfo);
        fileInfo.setMailInfoId(mailInfoId);
        fileInfoRepository.save(fileInfo);

    }

    private void parsFileInfos(FileInfo fileInfo) {

        String fileName = getFileName(fileInfo);

        log.info("Try to get File from byte array");
        File file = FileUtil.getFile(filePath, fileName, fileInfo.getFileBytes());

        String storageKey = fileInfo.getFileName();
        PartWarehouse partWarehouse = getPartStorage(storageKey);

        List<PartInfo> parts = tryToGetPartInfoList(partWarehouse, file);
        deletePreviousPartsAndSaveCurrent(parts, partWarehouse.getId());

    }

    private String getFileName(FileInfo fileInfo) {

        return fileInfo.getFileName() + "." + fileInfo.getExtension();
    }

    private void deletePreviousPartsAndSaveCurrent(List<PartInfo> partInfoList, short partStorageId) {

        partInfoRepository.deleteByPartWarehouseId(partStorageId);
        partInfoRepository.saveAll(partInfoList);

    }

    private List<PartInfo> tryToGetPartInfoList(PartWarehouse partWarehouse, File file) {

        List<PartInfo> partInfos = new ArrayList<>();

        log.info("Parse file rows.");

        try (FileInputStream fileStream = new FileInputStream(file);

             Workbook workbook = WorkbookFactory.create(fileStream)) {

            iterateAllRows(partWarehouse, partInfos, workbook);

            return partInfos;

        } catch (FileNotFoundException e) {

            throw new EmptyFileNotFoundException("Wrong file path.");

        } catch (IOException exception) {

            throw new WorkBookCreationIOException("Exception when Work Book creating.");

        } finally {

            FileUtil.tryDeleteFile(file);

        }
    }

    @SneakyThrows
    private void iterateAllRows(PartWarehouse partWarehouse, List<PartInfo> partInfos, Workbook workbook) {

        Sheet firstSheet = workbook.getSheetAt(ParserConstant.FIRST_SHEET);
        Map<String, Brand> brandMap = new HashMap<>();

        for (int currentRow = 0; currentRow < firstSheet.getLastRowNum(); currentRow++) {

            if (isFirstRow(currentRow)) continue;

            Row nextRow = firstSheet.getRow(currentRow);

            PartInfo partInfo = iterateOneRowAndGetPart(brandMap, nextRow);


            if (partInfo != null) {

                partInfo.setPartWarehouse(partWarehouse);
                partInfos.add(partInfo);

            }
        }
    }

    private boolean isFirstRow(int currentRow) {

        return currentRow == ParserConstant.FIRST_ROW;

    }

    private PartWarehouse getPartStorage(String storageKey) {

        return Optional.of(PartStorageConstant.PART_STORAGE_MAP.get(storageKey))
                .orElseThrow(() -> new WrongPartStorageKeyException("Wrong part storage key " + storageKey));
    }

    private PartInfo iterateOneRowAndGetPart(Map<String, Brand> brandMap, Row nextRow) {

        PartInfo partInfo = getEmptyPartInfo();

        for (short currentColumn = 0; currentColumn <= 5; currentColumn++) {

            Cell cell = nextRow.getCell(currentColumn);
            getAndSetCellTypeToPart(cell, partInfo, currentColumn);
            partInfo.setCreateDate(LocalDateTime.now());

        }

        return checkBrandAndCompletePartInfo(brandMap, partInfo);
    }

    private PartInfo getEmptyPartInfo() {

        PartInfo partInfo = new PartInfo();
        partInfo.setPart(new Part());
        partInfo.getPart().setBrand(new Brand());

        return partInfo;
    }

    private PartInfo checkBrandAndCompletePartInfo(Map<String, Brand> brandMap, PartInfo partInfo) {

        String brandNameFromFile = partInfo.getPart().getBrand().getName();

        Brand checkedBrand;

        if (brandMap.containsKey(brandNameFromFile)) {

            checkedBrand = brandMap.get(brandNameFromFile);

        } else {

            Optional<Brand> optionalBrand = brandRepository.findByName(brandNameFromFile);

            if (optionalBrand.isPresent()) {

                checkedBrand = optionalBrand.get();
                brandMap.put(checkedBrand.getName(), checkedBrand);

            } else {

                log.error("Brand " + brandNameFromFile + " is no present.");

                checkedBrand = brandRepository.save(new Brand(brandNameFromFile));
                brandMap.put(checkedBrand.getName(), checkedBrand);

                log.info("Brand " + brandNameFromFile + " was saved.");

            }
        }

        partInfo.getPart().setBrand(checkedBrand);
        checkPartIdAndSetInfo(partInfo);

        return partInfo;

    }


    private void checkPartIdAndSetInfo(PartInfo partInfo) {

        Optional<Part> optionalPart = partRepository.findByCodeAndAndBrandName(partInfo.getPart().getCode(), partInfo.getPart().getBrand().getName());

        if (optionalPart.isPresent()) {

            partInfo.setPart(optionalPart.get());

        } else {

            partInfo.getPart().setCreateDate(LocalDateTime.now());

            Part part = partInfo.getPart();
            part = partRepository.save(part);
            partInfo.setPart(part);

        }
    }

    private void getAndSetCellTypeToPart(Cell cell, PartInfo partInfo, short column) {

        switch (column) {

            case 0:
                partInfo.getPart().setCode(cell.getStringCellValue());
                partInfo.getPart().setCreateDate(LocalDateTime.now());
                break;

            case 1:
                partInfo.getPart().getBrand().setName(cell.getStringCellValue());
                break;

            case 2:
                partInfo.getPart().setDescription(cell.getStringCellValue());
                break;

            case 3:
                break;

            case 4:
                partInfo.setPrice(cell.getNumericCellValue());
                break;

            case 5:
                partInfo.setCount((int) cell.getNumericCellValue());
                break;

        }
    }
}


