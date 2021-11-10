package com.digital.lab.contractsmanagement.controller;

import com.digital.lab.contractsmanagement.ContractsManagementApplication;
import com.digital.lab.contractsmanagement.service.CompanyService;
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
public class CompanyResourceTest {

    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext wac;

    @Mock
    private CompanyService companyService;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

    }


    @Test
    public void testCaseCreateCompany() throws Exception {
        String jsonRequestFoCreateCompany="{\"id\": \"1\",\"name\": \"NEQSOL\"}";

        mockMvc.perform(MockMvcRequestBuilders.post("/company/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequestFoCreateCompany)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.name").exists())
                .andExpect(jsonPath("$.name").value("NEQSOL"))
                .andDo(print());
    }

}
