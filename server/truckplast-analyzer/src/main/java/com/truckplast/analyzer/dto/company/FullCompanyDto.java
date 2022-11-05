package com.truckplast.analyzer.dto.company;

import com.truckplast.analyzer.dto.user.UserDtoWithoutCompany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FullCompanyDto {

    private Long id;

    private String name;

    private Set<UserDtoWithoutCompany> users;
}
