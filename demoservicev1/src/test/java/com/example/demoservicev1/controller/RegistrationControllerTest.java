package com.example.demoservicev1.controller;

import com.example.demoservicev1.model.RegisterUserRequest;
import com.example.demoservicev1.repository.DatabaseRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class RegistrationControllerTest {
  @Autowired
  MockMvc mockMvc;

  @MockBean
  DatabaseRepository databaseRepository;

  private ObjectMapper objectMapper = new ObjectMapper();


  @ParameterizedTest
  @ValueSource(ints = {0, 1})
  void shouldRegisterTheUserAndReturnSuccess(Integer dbReturnCode) throws Exception {
    RegisterUserRequest input = getInput();
    when(databaseRepository.registerUser(any())).thenReturn(dbReturnCode);

    mockMvc.perform(post("/register")
            .contentType("application/json")
            .content(objectMapper.writeValueAsString(input)))
            .andExpect(status().isOk())
            .andExpect(content().string(String.valueOf(dbReturnCode)));

  }

  RegisterUserRequest getInput() {
    return new RegisterUserRequest(
            "uName", "fName", "lName", "pwd", "hint");
  }


}