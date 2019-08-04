package com.example.demoservicev1.controller;

import com.example.demoservicev1.Repository.databaseRepository;
import com.example.demoservicev1.model.Login;
import com.example.demoservicev1.model.Pwd;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginVerification {

    private databaseRepository dr;

    public LoginVerification(databaseRepository dr){
        this.dr = dr;
    }

    @PostMapping(path = "/verify", consumes = "application/json")
    public boolean verifyLogin(@RequestBody Login login){
        System.out.println("Request received is " + login);

        Pwd pwdResponse = dr.getUserInfo(login.getLogin());
        return (pwdResponse != null && !pwdResponse.getPwd().isEmpty()) && pwdResponse.getPwd().equals(login.getPassword());

    }
}
