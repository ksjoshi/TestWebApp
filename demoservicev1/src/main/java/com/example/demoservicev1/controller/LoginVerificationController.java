package com.example.demoservicev1.controller;

import com.example.demoservicev1.model.Login;
import com.example.demoservicev1.model.TestObject;
import com.example.demoservicev1.model.UserInfo;
import com.example.demoservicev1.repository.DatabaseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDate;

@RestController
@Slf4j
public class LoginVerificationController {

  private DatabaseRepository databaseRepository;

  public LoginVerificationController(DatabaseRepository databaseRepository) {
    this.databaseRepository = databaseRepository;
  }

  @PostMapping(path = "/verify", consumes = "application/json")
  public boolean verifyLogin(@RequestBody Login login) {
    System.out.println("Request received is " + login);
    try {
      UserInfo userInfoResponse = databaseRepository.getUserInfo(login.getLogin());
      return (userInfoResponse != null
              && !userInfoResponse.getPwd().isEmpty())
              && userInfoResponse.getPwd().equals(login.getPassword());
    } catch (Exception e) {
      log.error("Caught exception while verifying the data.", e);
      return false;
    }
  }

  @GetMapping("/test")
  public TestObject test() throws IOException {
    TestObject t = TestObject.builder()
            .currentDate(LocalDate.now())
            .field1("field1")
            .build();
    return t;
  }

  //Added only for testing cloud contract
  @GetMapping(value = "/validate/prime-number")
  public String test(@RequestParam String number) throws IOException {
    if(Integer.parseInt(number) %2 == 0 )
      return "Even";
    return "Odd";
  }
}
