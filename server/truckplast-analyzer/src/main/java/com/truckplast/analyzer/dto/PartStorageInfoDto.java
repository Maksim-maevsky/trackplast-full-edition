package com.truckplast.analyzer.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartStorageInfoDto {

    private PartStorageDto partStorage;

    private int countOfParts;

    private double volumeAtALowPrice;

}
