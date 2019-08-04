package com.example.demoservicev1.controller;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@WebMvcTest
public class LoginVerificationTest {

    @Autowired
    MockMvc mockMvc;


   private final String validRequest = "{\"login\":\"dummy\",\"password\":\"dummy\"}";
   private final String invalidRequest = "{\"login\":\"dummy\",\"password\":\"false dummy\"}";
   private  String invalidEmptyRequest = "{\"login\":\"\",\"password\":\"\"}";


    @BeforeAll
    void setUp(){

    }

    @Test
    public void shouldReturnTrueVerificationResult() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/verify")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(validRequest))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().string("true"));
    }

    @Test
    public void shouldReturnFalseVerificationResult() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/verify")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(invalidRequest))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().string("false"));
    }

    @Test
    public void shouldReturnFalseIfCredentialsAreEmpty() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/verify")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(invalidEmptyRequest))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().string("false"));

        invalidEmptyRequest = "{\"login\":\"login\",\"password\":\"\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/verify")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(invalidEmptyRequest))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().string("false"));
    }


}