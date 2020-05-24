package com.example.demoservicev1.model;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;

@Value
@Builder
public class TestObject {
  String field1;
  LocalDate currentDate;
}
