package com.example.demoservicev1.controller;

import com.example.demoservicev1.Repository.DatabaseRepository;
import com.example.demoservicev1.model.RegisterUserRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class RegistrationController {

    private DatabaseRepository databaseRepository;

    public RegistrationController(DatabaseRepository databaseRepository) {
        this.databaseRepository = databaseRepository;
    }

    @PostMapping(value = "/register", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Integer registerUser(@RequestBody RegisterUserRequest registerUserRequest) {
        Integer response = databaseRepository.registerUser(registerUserRequest);
        log.info("Data inserted ? - {}", response);
        return  response;
    }
}
