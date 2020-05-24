package com.example.demoservicev1.contracts;

import com.example.demoservicev1.Demoservicev1Application;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.web.context.WebApplicationContext;

@SpringJUnitConfig
@SpringBootTest(classes = Demoservicev1Application.class)
@DirtiesContext
@AutoConfigureMessageVerifier
public class WebRestBase {

  @Autowired
  private WebApplicationContext webApplicationContext;

  @BeforeEach
  void setUp() {
    RestAssuredMockMvc.webAppContextSetup(webApplicationContext);
  }
}
