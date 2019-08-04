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

    final private WebProcessBO webProcessBO;


    public LoginController(WebProcessBO webProcessBO) {
        this.webProcessBO = webProcessBO;
    }

    @GetMapping("/login")
    public ModelAndView login(){

        return new ModelAndView("Login");
    }

    @PostMapping("/submit")
    public ModelAndView submit(@ModelAttribute("loginVO") LoginVO loginVO){
        if(webProcessBO.process(loginVO)) {
            return new ModelAndView("submit");
        }
        return new ModelAndView("Login").addObject("error", "Invalid Credentials");
    }

    @GetMapping("/setting")
    public ModelAndView setting() {
        return new ModelAndView("setting");
    }

    @GetMapping("/logout")
    public ModelAndView logout() {
        return new ModelAndView("redirect:/login");
    }

    @ModelAttribute("loginVO")
    public LoginVO loginVO(){
        return new LoginVO();
    }
}
