package com.digital.lab.contractsmanagement.controller;

 import com.digital.lab.contractsmanagement.model.Company;
 import com.digital.lab.contractsmanagement.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {
    @Autowired
    private CompanyService companyService;


    @PostMapping("company/save")
    public ResponseEntity<Company> save(@RequestBody Company company){
        Company c= companyService.save(company);
        return new ResponseEntity<Company>(c, HttpStatus.CREATED);
    }
}
