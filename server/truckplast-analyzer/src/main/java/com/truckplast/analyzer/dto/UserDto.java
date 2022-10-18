package com.truckplast.analyzer.dto;

import com.truckplast.analyzer.entity.part.Position;
import com.truckplast.analyzer.entity.part.Role;
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

    private Position position;

    private Set<Role> roles;

    private boolean isBlock;
}
