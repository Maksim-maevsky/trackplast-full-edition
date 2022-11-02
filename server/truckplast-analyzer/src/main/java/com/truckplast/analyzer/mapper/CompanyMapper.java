package com.truckplast.analyzer.mapper;

import com.truckplast.analyzer.dto.company.CompanyDtoWithoutUsers;
import com.truckplast.analyzer.dto.company.FullCompanyDto;
import com.truckplast.analyzer.entity.Company;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

    @Named(value = "fullCompanyDto")
    Company toCompany(FullCompanyDto fullCompanyDto);

    @Named(value = "companyDtoWithoutUsers")
    Company toCompany(CompanyDtoWithoutUsers companyDtoWithoutUsers);

    @Named(value = "companyEntity")
    FullCompanyDto toFullCompanyDto(Company company);

    @Named(value = "companyEntity")
    CompanyDtoWithoutUsers toCompanyDtoWithoutUsers(Company company);


    @IterableMapping(qualifiedByName = "fullCompanyDto")
    List<Company> mapFromFullCompanyDtoToCompanyList(List<FullCompanyDto> fullCompanyDtoList);

    @IterableMapping(qualifiedByName = "companyDtoWithoutUsers")
    List<Company> mapFromWithoutUsersCompanyDtoToCompanyList(List<CompanyDtoWithoutUsers> companyDtoWithoutUsersList);

    @IterableMapping(qualifiedByName = "companyEntity")
    List<FullCompanyDto> mapToFullCompanyDtoList(List<Company> companyEntityList);

    @IterableMapping(qualifiedByName = "companyEntity")
    List<CompanyDtoWithoutUsers> mapToCompanyDtoWithoutUsersList(List<Company> companyEntityList);
}
