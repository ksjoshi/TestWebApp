package com.example.demo.controller;


import com.example.demo.BO.WebProcessBO;
import com.example.demo.VO.LoginVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    private WebProcessBO webProcessBO;

    public LoginController(WebProcessBO webProcessBO) {
        System.out.println("inside constructor");
        this.webProcessBO = webProcessBO;
    }

    @GetMapping
    public ModelAndView login(){
        return new ModelAndView("login");
    }

    @PostMapping
    public ModelAndView submit(@ModelAttribute LoginVO loginVO){
        System.out.println(loginVO.getLogin() +" - " + loginVO.getPassword());
        webProcessBO.process();
        return new ModelAndView("submit");
    }

}
