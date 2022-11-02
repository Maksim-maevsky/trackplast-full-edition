package com.truckplast.analyzer.service.user;

import com.truckplast.analyzer.dto.company.CompanyDtoWithoutUsers;
import com.truckplast.analyzer.dto.company.FullCompanyDto;

import java.util.List;

public interface CompanyService {

    FullCompanyDto getById(Long id);

    List<FullCompanyDto> getAll();

    FullCompanyDto create(FullCompanyDto fullCompanyDto);

    FullCompanyDto update(FullCompanyDto fullCompanyDto);

    void delete(Long id);

    boolean isCompanyExist(CompanyDtoWithoutUsers companyDtoWithoutUsers);
}
