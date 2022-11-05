package com.truckplast.analyzer.dto.user;

import com.truckplast.analyzer.dto.company.CompanyDtoWithoutUsers;
import com.truckplast.analyzer.dto.PositionDto;
import com.truckplast.analyzer.dto.RoleDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FullUserDto {

    private Long id;

    private String name;

    private String surName;

    private String mailAddress;

    private PositionDto position;

    private Set<RoleDto> roles;

    private CompanyDtoWithoutUsers company;

    private boolean isBlock;
}
