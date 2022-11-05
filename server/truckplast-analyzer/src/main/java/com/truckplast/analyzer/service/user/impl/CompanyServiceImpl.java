package com.truckplast.analyzer.service.user.impl;

import com.truckplast.analyzer.dto.company.CompanyDtoWithoutUsers;
import com.truckplast.analyzer.dto.company.FullCompanyDto;
import com.truckplast.analyzer.entity.Company;
import com.truckplast.analyzer.exeption_handler.exception.CompanyNotFoundException;
import com.truckplast.analyzer.exeption_handler.exception.NoSuchCompanyException;
import com.truckplast.analyzer.mapper.CompanyMapper;
import com.truckplast.analyzer.repository.CompanyRepository;
import com.truckplast.analyzer.service.user.CompanyService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    private final CompanyMapper mapper;


    @Override
    public FullCompanyDto getById(Long id) {

        Company company = companyRepository.findById(id).orElseThrow(() -> new CompanyNotFoundException("Company not found."));

        return mapper.toFullCompanyDto(company);
    }

    @Override
    public List<FullCompanyDto> getAll() {

        List<Company> companyList = companyRepository.findAll();

        return mapper.mapToFullCompanyDtoList(companyList);
    }

    @Override
    public FullCompanyDto create(FullCompanyDto fullCompanyDto) {

        Company company = mapper.toCompany(fullCompanyDto);

        Company savedCompany = companyRepository.save(company);

        return mapper.toFullCompanyDto(savedCompany);
    }

    @Override
    public FullCompanyDto update(FullCompanyDto fullCompanyDto) {

        Company company = mapper.toCompany(fullCompanyDto);

        Company savedCompany = companyRepository.save(company);

        return mapper.toFullCompanyDto(savedCompany);
    }

    @Override
    public void delete(Long id) {

        companyRepository.deleteById(id);
    }

    @Override
    public boolean isCompanyExist(CompanyDtoWithoutUsers companyDtoWithoutUsers) {

        if (companyRepository.findByName(companyDtoWithoutUsers.getName()).isPresent()){

            return true;
        }

        throw new NoSuchCompanyException("No such company.");
    }
}
