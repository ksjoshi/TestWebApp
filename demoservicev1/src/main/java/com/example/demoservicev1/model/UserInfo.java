package com.example.demoservicev1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
@AllArgsConstructor
public class UserInfo {
    Integer id;
    String username;
    String first_name;
    String last_name;
    String pwd;
    String hint;
}