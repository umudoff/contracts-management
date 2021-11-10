package com.digital.lab.contractsmanagement.rest;


import com.digital.lab.contractsmanagement.ContractsManagementApplication;
import com.digital.lab.contractsmanagement.model.Company;
import com.digital.lab.contractsmanagement.model.Contract;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ContractsManagementApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ContractRestTest {
    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();

    HttpHeaders headers = new HttpHeaders();


    @Autowired
    private TestRestTemplate template;

    @Test
    public void testContractShouldBeCreated() {
        final String method="/contract/save";

        Contract c1= new Contract(new Long(1),
                                  new Company(new Long(1),"SAP"),
                                  new Company(new Long(2),"SalesForce"));
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Contract> entity = new HttpEntity<Contract>(c1, headers);

        ResponseEntity<Contract> response = template.exchange(createURLWithPort(method),
                HttpMethod.POST,
                entity,
                Contract.class);

        Assert.assertTrue((response.getStatusCode()).equals(HttpStatus.CREATED));
    }


    private String createURLWithPort(String uri) {
        return "http://localhost:"+ port + uri;
    }

}

