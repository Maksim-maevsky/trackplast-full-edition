package com.truckplast.analyzer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;

    private String name;

    private String surName;

    private String mailAddress;

    private PositionDto position;

    private Set<RoleDto> roles;

    private boolean isBlock;
}
