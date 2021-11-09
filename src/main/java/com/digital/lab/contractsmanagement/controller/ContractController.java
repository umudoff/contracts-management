package com.digital.lab.contractsmanagement.controller;

import com.digital.lab.contractsmanagement.model.Company;
import com.digital.lab.contractsmanagement.model.Contract;
import com.digital.lab.contractsmanagement.service.ContractService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("Contract Management Endpoint")
@RestController
public class ContractController {

    @Autowired
    private ContractService contractService;

    @ApiOperation(value="Calculate all possible sleeves", notes="Provide two companies")
    @GetMapping("/sleeves")
    public ResponseEntity<List<List<Long>>> getAllSleeves(@RequestParam Long recipient, @RequestParam Long provider){
        List<List<Long>> sleeves= contractService.getAllSleeves(recipient, provider);
        return new ResponseEntity<List<List<Long>>>(sleeves, HttpStatus.OK);
    }


    @PostMapping("contract/save")
    public ResponseEntity<Contract> save(@RequestBody Contract contract){
       Contract c= contractService.save(contract);
       return new ResponseEntity<Contract>(c, HttpStatus.CREATED);
    }

}
