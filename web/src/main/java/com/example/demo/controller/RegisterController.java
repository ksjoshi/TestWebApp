package com.example.demo.controller;

import com.example.demo.BO.WebProcessBO;
import com.example.demo.VO.RegisterUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class RegisterController {

    private WebProcessBO webProcessBO;

    public RegisterController(WebProcessBO webProcessBO){
        this.webProcessBO = webProcessBO;
    }

    @PostMapping("/register")
    @ResponseBody
    public String registerUser(@RequestBody RegisterUser registerUser) {
        Integer userRegistered = webProcessBO.registerUser(registerUser);
        return (userRegistered != 0)? "Success" : "Fail";
    }

    @GetMapping("/register")
    public ModelAndView register() {
        return new ModelAndView("Register");
    }

}
