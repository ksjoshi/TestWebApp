package com.example.demo.VO;

import lombok.Getter;
import lombok.Value;

@Value
@Getter
public class RegisterUser {
    String userName;
    String firstName;
    String lastName;
    String pwd;
    String hint;

}
