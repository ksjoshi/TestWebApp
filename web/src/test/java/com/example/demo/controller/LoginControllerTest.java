package com.example.demo.controller;

import com.example.demo.BO.WebProcessBO;
import com.example.demo.VO.LoginVO;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest
public class LoginControllerTest {
    @MockBean
    WebProcessBO webProcessBO;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldGetOKStatusonGETcall() throws Exception {
        this.mockMvc.perform(get("/login"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(containsString("Login")));
    }

    @Test
    public void shouldAcceptTheFormAndReturnNextController() throws Exception {
        LoginVO loginVO = new LoginVO();
        loginVO.setLogin("dummy");
        loginVO.setPassword("dummy");
        when(webProcessBO.process(ArgumentMatchers.any())).thenReturn(true);

        this.mockMvc.perform(post("/submit").contentType(APPLICATION_FORM_URLENCODED)
                .param("login", "dummy")
                .param("password","dummy"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(containsString("Welcome")));
    }

    @Test
    public void shouldAcceptTheFormAndReturnLoginView() throws Exception {
        LoginVO loginVO = new LoginVO();
        loginVO.setLogin("dummy");
        loginVO.setPassword("dummy");
        when(webProcessBO.process(loginVO)).thenReturn(false);

        this.mockMvc.perform(post("/submit").contentType(APPLICATION_FORM_URLENCODED)
                .param("login", "dummy")
                .param("password","dummy"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(containsString("Login")));
    }

    @Test
    public void shouldReturnStteingViewWhenClickedOnSettingLink() throws Exception {
        mockMvc.perform(get("/setting"))
                .andExpect(status().isOk())
                .andExpect(view().name("setting"));
    }

    @Test
    public void shouldLogouttheUserAndLoginViewShouldBeReturned() throws Exception {

        mockMvc.perform(get("/logout"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/login"));
    }


}

