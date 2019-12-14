package com.example.demoservicev1;

import com.example.demoservicev1.config.Received;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding({Received.class})
public class Demoservicev1Application {

  public static void main(String[] args) {
    SpringApplication.run(Demoservicev1Application.class, args);
  }

}
