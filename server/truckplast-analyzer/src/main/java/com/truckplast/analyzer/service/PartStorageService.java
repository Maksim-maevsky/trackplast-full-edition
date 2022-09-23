package com.truckplast.analyzer.service;

import com.truckplast.analyzer.dto.PartStorageDto;
import com.truckplast.analyzer.dto.PartStorageInfoDto;

import java.util.List;

public interface PartStorageService {

    List<PartStorageDto> getPartStorageDtoList();

    List<PartStorageInfoDto> getStorageInfo();

}
