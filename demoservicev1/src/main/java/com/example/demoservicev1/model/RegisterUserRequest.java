package com.example.demoservicev1.model;

import lombok.Getter;

@Getter
public class RegisterUserRequest {
    private String userName;
    private String firstName;
    private String lastName;
    private String pwd;
    private String hint;

    public RegisterUserRequest(String userName, String firstName, String lastName, String pwd, String hint) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.pwd = pwd;
        this.hint = hint;
    }

    public RegisterUserRequest(){}
}
