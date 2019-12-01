package com.example.demoservicev1.controller;

import com.example.demoservicev1.Repository.DatabaseRepository;
import com.example.demoservicev1.model.Login;
import com.example.demoservicev1.model.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class LoginVerificationController {

    private DatabaseRepository databaseRepository;

    public LoginVerificationController(DatabaseRepository databaseRepository){
        this.databaseRepository = databaseRepository;
    }

    @PostMapping(path = "/verify", consumes = "application/json")
    public boolean verifyLogin(@RequestBody Login login){
        System.out.println("Request received is " + login);
        try {
            UserInfo userInfoResponse = databaseRepository.getUserInfo(login.getLogin());
            return (userInfoResponse != null && !userInfoResponse.getPwd().isEmpty()) && userInfoResponse.getPwd().equals(login.getPassword());
        } catch (Exception e) {
            log.error("Caught exception while verifying the data.", e);
            return false;
        }

    }
}
