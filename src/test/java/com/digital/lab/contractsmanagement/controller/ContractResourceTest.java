package com.digital.lab.contractsmanagement.controller;

import com.digital.lab.contractsmanagement.ContractsManagementApplication;
import com.digital.lab.contractsmanagement.service.ContractService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ContractsManagementApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ContractResourceTest {

    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext wac;

    @Mock
    private ContractService contractService;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

    }



    @Test
    public void testCaseCreateContract() throws Exception {
        String jsonRequestFoCreateContract="{\"id\": 1, \"provider\": { \"id\": 2, \"name\": \"SAP\" },\"recipient\": {\"id\": 3,\"name\": \"SalesForce\" } }";

        mockMvc.perform(MockMvcRequestBuilders.post("/contract/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequestFoCreateContract)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.provider.id").exists())
                .andExpect(jsonPath("$.provider.name").exists())
                .andExpect(jsonPath("$.recipient.id").exists())
                .andExpect(jsonPath("$.recipient.name").exists())
                .andExpect(jsonPath("$.provider.name").value("SAP"))
                .andExpect(jsonPath("$.recipient.name").value("SalesForce"))
                .andDo(print());
    }


}
