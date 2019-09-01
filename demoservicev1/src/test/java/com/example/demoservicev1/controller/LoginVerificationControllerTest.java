package com.example.demoservicev1.controller;


import com.example.demoservicev1.Repository.DatabaseRepository;
import com.example.demoservicev1.model.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class LoginVerificationControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    DatabaseRepository databaseRepository;

   // private DatabaseRepository databaseRepository = mock(DatabaseRepository.class);
    private final String validRequest = "{\"login\":\"dummy\",\"password\":\"dummy\"}";
    private final String invalidRequest = "{\"login\":\"dummy\",\"password\":\"false dummy\"}";
    private String invalidEmptyRequest = "{\"login\":\"\",\"password\":\"\"}";

    @Test
    void shouldReturnTrueVerificationResult() throws Exception {
        UserInfo userInfo = new UserInfo(1,"dummy","fName","lName","dummy","hint");
        when(databaseRepository.getUserInfo("dummy")).thenReturn(userInfo);
        mockMvc.perform(post("/verify")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(validRequest))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }

    @Test
    void shouldReturnFalseVerificationResult() throws Exception {
        UserInfo userInfo = new UserInfo(1,"dummy","fName","lName","pwd","hint");
        when(databaseRepository.getUserInfo("dummy")).thenReturn(userInfo);
        mockMvc.perform(post("/verify")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(invalidRequest))
                .andExpect(status().isOk())
                .andExpect(content().string("false"));
    }

    @Test
    void shouldReturnFalseIfCredentialsAreEmpty() throws Exception {
        mockMvc.perform(post("/verify")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(invalidEmptyRequest))
                .andExpect(status().isOk())
                .andExpect(content().string("false"));

        invalidEmptyRequest = "{\"login\":\"login\",\"password\":\"\"}";
        mockMvc.perform(post("/verify")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(invalidEmptyRequest))
                .andExpect(status().isOk())
                .andExpect(content().string("false"));
    }

}
