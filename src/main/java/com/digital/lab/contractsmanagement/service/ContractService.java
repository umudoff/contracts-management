package com.digital.lab.contractsmanagement.service;

import com.digital.lab.contractsmanagement.model.Company;
import com.digital.lab.contractsmanagement.model.Contract;
import com.digital.lab.contractsmanagement.repository.CompanyRepository;
import com.digital.lab.contractsmanagement.repository.ContractRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Slf4j
@Service
public class ContractService {

    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private CompanyRepository companyRepository;

    public Contract save(Contract contract) {
        return contractRepository.save(contract);
    }



    public List<List<Long>> getAllSleeves(Long provider,Long recipient ) {
          List<List<Long>> sleeves = contractRepository.findAllSleeves(provider, recipient);
        return  sleeves;//mergePairs(sleeves);
    }


    public List<Set<Long>> mergePairs(List<List<Long>> sleeves) {
        List<Set<Long>> lst = new LinkedList<>();
        Set<Long> init = new HashSet<>();
        init.add(sleeves.get(0).get(0));
        init.add(sleeves.get(0).get(1));
        lst.add(init);
        List<Set<Long>> setsRecord = new LinkedList<>();
        boolean found = false;
        Long i1, i2;
        for (int i = 1; i < sleeves.size(); i++) {
            i1 = sleeves.get(i).get(0);
            i2 = sleeves.get(i).get(1);
            for (Set<Long> set : lst) {
                if (set.contains(i1) || set.contains(i2)) {
                    if (setsRecord.size() >= 1) {
                        setsRecord.get(0).addAll(set);
                        lst.remove(set);
                    } else {
                        set.add(i1);
                        set.add(i2);
                        setsRecord.add(set);
                    }
                    found = true;
                }
            }
            setsRecord.clear();
            if (!found) {
                Set<Long> newSet = new HashSet<Long>();
                newSet.add(i1);
                newSet.add(i2);
                lst.add(newSet);
            }
            found = false;
        }

        return  lst;
    }


}
