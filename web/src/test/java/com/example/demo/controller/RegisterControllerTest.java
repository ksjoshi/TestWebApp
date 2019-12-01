package com.example.demo.controller;

import com.example.demo.BO.WebProcessBO;
import com.example.demo.VO.RegisterUser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class RegisterControllerTest {

    @MockBean
    WebProcessBO webProcessBO;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    RegisterController registerController;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void shouldRegisterProvidedUser() throws Exception {
        RegisterUser input = getResgisterUserInput();
        when(webProcessBO.registerUser(input)).thenReturn(1);
        this.mockMvc.perform(post("/register")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(input)))
                .andExpect(status().isOk())
                .andExpect(content().string("Success"));

    }

    @Test
    void shouldNotRegisterProvidedUserIfThereIsError() throws Exception {
        RegisterUser input = getResgisterUserInput();
        when(webProcessBO.registerUser(input)).thenReturn(0);
        this.mockMvc.perform(post("/register")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(input)))
                .andExpect(status().isOk())
                .andExpect(content().string("Fail"));

    }

    @Test
    void shouldCallRegisterWithProvidedUserInformationAndReturnSuccess() {
        RegisterUser input = getResgisterUserInput();
        when(webProcessBO.registerUser(input)).thenReturn(1);
        String actual = registerController.registerUser(input);
        verify(webProcessBO).registerUser(eq(input));
        assertThat(actual).isEqualTo("Success");
    }

    @Test
    void shouldCallRegisterWithProvidedUserInformationAndReturnFail() {
        RegisterUser input = getResgisterUserInput();
        when(webProcessBO.registerUser(input)).thenReturn(0);
        String actual = registerController.registerUser(input);
        verify(webProcessBO).registerUser(eq(input));
        assertThat(actual).isEqualTo("Fail");
    }

    @Test
    void shouldReturnRegisterModelAnView() throws Exception {
        mockMvc.perform(get("/register"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Register")));
    }

    RegisterUser getResgisterUserInput() {
        return new RegisterUser(
                "uName","fName", "lName","pwd", "hint"
        );
    }

}