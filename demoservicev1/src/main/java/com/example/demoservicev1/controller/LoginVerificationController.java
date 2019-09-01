package com.example.demoservicev1.controller;

import com.example.demoservicev1.Repository.DatabaseRepository;
import com.example.demoservicev1.model.Login;
import com.example.demoservicev1.model.UserInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginVerificationController {

    private DatabaseRepository databaseRepository;

    public LoginVerificationController(DatabaseRepository databaseRepository){
        this.databaseRepository = databaseRepository;
    }

    @PostMapping(path = "/verify", consumes = "application/json")
    public boolean verifyLogin(@RequestBody Login login){
        System.out.println("Request received is " + login);

        UserInfo userInfoResponse = databaseRepository.getUserInfo(login.getLogin());
        return (userInfoResponse != null && !userInfoResponse.getPwd().isEmpty()) && userInfoResponse.getPwd().equals(login.getPassword());

    }
}
