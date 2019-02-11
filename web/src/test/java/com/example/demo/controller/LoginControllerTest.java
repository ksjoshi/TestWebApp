package com.example.demo.controller;

import com.example.demo.BO.WebProcessBO;
import com.example.demo.VO.LoginVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED;

@RunWith(SpringRunner.class)
@WebMvcTest
public class LoginControllerTest {
    @MockBean
    WebProcessBO webProcessBO;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldGetOKStatusonGETcall() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/login"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(containsString("Login")));
    }

    @Test
    public void shouldAcceptTheFormAndReturnNextController() throws Exception {
        LoginVO loginVO = new LoginVO();
        loginVO.setLogin("dummy");
        loginVO.setPassword("dummy");
        Mockito.doNothing().when(webProcessBO).process(loginVO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/login").contentType(APPLICATION_FORM_URLENCODED)
                .param("login", "dummy")
                .param("password","dummy"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(containsString("Welcome")));
    }
}

