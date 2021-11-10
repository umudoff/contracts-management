package com.digital.lab.contractsmanagement.service;

import com.digital.lab.contractsmanagement.ContractsManagementApplication;
import com.digital.lab.contractsmanagement.model.Company;
import com.digital.lab.contractsmanagement.repository.CompanyRepository;
import com.digital.lab.contractsmanagement.service.CompanyService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ContractsManagementApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CompanyServiceTest {
    @Mock
    private CompanyRepository companyRepository;

    @InjectMocks
    private CompanyService companyService;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testCaseGetAllApplications(){
        List<Company> companies = Arrays.asList(
                new Company(new Long(1),"SAP"),
                new Company(new Long(2),"SalesForce"));
        when(companyRepository.findAll()).thenReturn(companies);

        List<Company> result = companyService.findAll();
        assertEquals(2, result.size());
    }
}
