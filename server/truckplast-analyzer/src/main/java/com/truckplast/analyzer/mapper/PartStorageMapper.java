package com.truckplast.analyzer.mapper;


import com.truckplast.analyzer.dto.PartStorageDto;
import com.truckplast.analyzer.entity.part.PartWarehouse;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PartStorageMapper {

    @Named(value = "partStorage")
    PartStorageDto toPartStorageDtoFromPartStorage(PartWarehouse partWarehouse);

    @Named(value = "partStorageDto")
    PartWarehouse toPartStorageFromPartStorageDto(PartStorageDto partStorageDto);

    @IterableMapping(qualifiedByName = "partStorage")
    List<PartStorageDto> mapPartStorageDtoListFromPartStorageList(List<PartWarehouse> partWarehouseList);

}