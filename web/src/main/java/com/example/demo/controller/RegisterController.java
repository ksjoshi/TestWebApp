package com.example.demo.controller;

import com.example.demo.bo.WebProcessBO;
import com.example.demo.vo.RegisterUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class RegisterController {

  private WebProcessBO webProcessBO;

  public RegisterController(WebProcessBO webProcessBO) {
    this.webProcessBO = webProcessBO;
  }

  @PostMapping(value = "/register")
  public String registerUser(@ModelAttribute("registerUser") RegisterUser registerUser) {
    Integer userRegistered = webProcessBO.registerUser(registerUser);
    return (userRegistered != 0) ? "Registration/Success" : "Registration/Fail";
  }

  @GetMapping("/register")
  public ModelAndView register() {
    return new ModelAndView("Registration/Register");
  }

}
