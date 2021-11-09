package com.digital.lab.contractsmanagement.service;

import com.digital.lab.contractsmanagement.model.Company;
import com.digital.lab.contractsmanagement.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    public Company save(Company company){
        return companyRepository.save(company);
    }
}
