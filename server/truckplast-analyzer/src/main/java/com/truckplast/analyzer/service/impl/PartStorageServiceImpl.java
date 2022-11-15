package com.truckplast.analyzer.service.impl;

import com.truckplast.analyzer.dto.PartStorageDto;
import com.truckplast.analyzer.dto.PartStorageInfoDto;
import com.truckplast.analyzer.entity.part.PartWarehouse;
import com.truckplast.analyzer.mapper.PartStorageMapper;
import com.truckplast.analyzer.repository.PartInfoRepository;
import com.truckplast.analyzer.repository.PartStorageRepository;
import com.truckplast.analyzer.service.PartStorageService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Data
@Slf4j
public class PartStorageServiceImpl implements PartStorageService {

   private final PartStorageRepository partStorageRepository;

   private final PartInfoRepository partInfoRepository;

   private final PartStorageMapper partStorageMapper;


    @Override
    public List<PartStorageDto> getPartStorageDtoList() {

        log.info("Try get all partStorages from db");

        List<PartWarehouse> partWarehouses = partStorageRepository.findAll();

        return partStorageMapper.mapPartStorageDtoListFromPartStorageList(partWarehouses);
    }

    @Override
    public List<PartStorageInfoDto> getStorageInfo(){

        List<PartWarehouse> partWarehouseList = partStorageRepository.findAll();
        List<PartStorageInfoDto> partStorageInfoDtoList = new ArrayList<>();

        for(PartWarehouse ps : partWarehouseList){

            PartStorageInfoDto partStorageInfoDto = new PartStorageInfoDto();

            int partCount = partInfoRepository.countAllByPartWarehouseId(ps.getId());
            Optional<Double> volumeAtALowPrice = partInfoRepository.countAllPriceByPartWarehouseId(ps.getId());
            if(volumeAtALowPrice.isPresent()){

                partStorageInfoDto.setVolumeAtALowPrice(volumeAtALowPrice.get());

            }

            partStorageInfoDto.setPartStorage(partStorageMapper.toPartStorageDtoFromPartStorage(ps));
            partStorageInfoDto.setCountOfParts(partCount);


            partStorageInfoDtoList.add(partStorageInfoDto);

        }

        return partStorageInfoDtoList;
    }

}
