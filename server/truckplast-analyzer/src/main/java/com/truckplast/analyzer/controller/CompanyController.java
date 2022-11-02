package com.truckplast.analyzer.controller;

import com.truckplast.analyzer.dto.company.CompanyDtoWithoutUsers;
import com.truckplast.analyzer.dto.company.FullCompanyDto;
import com.truckplast.analyzer.service.user.CompanyService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
@Data
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping
    public List<FullCompanyDto> getAll(){

        return companyService.getAll();
    }

    @GetMapping("/{id}")
    public FullCompanyDto getById(@PathVariable Long id){

        return companyService.getById(id);
    }

    @PostMapping
    public FullCompanyDto create(@RequestBody FullCompanyDto fullCompanyDto){

        return companyService.create(fullCompanyDto);
    }

    @PutMapping
    public FullCompanyDto update(@RequestBody FullCompanyDto fullCompanyDto){

        return companyService.update(fullCompanyDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){

        companyService.delete(id);
    }

}
