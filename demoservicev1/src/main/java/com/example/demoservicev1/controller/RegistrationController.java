package com.example.demoservicev1.controller;

import com.example.demoservicev1.model.RegisterUserRequest;
import com.example.demoservicev1.repository.DatabaseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class RegistrationController {

  private DatabaseRepository databaseRepository;
  @Autowired
  private JavaMailSender javaMailSender;

  public RegistrationController(DatabaseRepository databaseRepository) {
    this.databaseRepository = databaseRepository;
  }

  @PostMapping(value = "/register", consumes = {MediaType.APPLICATION_JSON_VALUE})
  public Integer registerUser(@RequestBody RegisterUserRequest registerUserRequest) {
    Integer response = databaseRepository.registerUser(registerUserRequest);
    //sendEmail();
    log.info("Data inserted ? - {}", response);
    return response;
  }

  @PostMapping(value = "/sendEmail")
  public void sendEmailNotification() {
    sendEmail();
  }

  private void sendEmail() {
    SimpleMailMessage msg = new SimpleMailMessage();
    msg.setTo("shalengg@gmail.com", "kedar.s.joshi@bitwiseglobal.com");

    msg.setSubject("Testing from my application");
    msg.setText("Testing email from my application.");

    javaMailSender.send(msg);
  }
}
