package com.digital.lab.contractsmanagement.service;

import com.digital.lab.contractsmanagement.model.Company;
import com.digital.lab.contractsmanagement.model.Contract;
import com.digital.lab.contractsmanagement.repository.ContractRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ContractService {

    @Autowired
    private ContractRepository contractRepository;

    public Contract save(Contract contract){
        log.info("Saving Contract with {}",contract.getId());
        return contractRepository.save(contract);
    }

    public  List<List<Long>> getAllSleeves(Long recipient, Long provider){
        List<List<Long>> sleeves= contractRepository.findAllSleeves(recipient, provider);
        return sleeves;
    }

}
