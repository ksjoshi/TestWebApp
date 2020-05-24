package com.example.demo.VO;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class TestObject {
  String field1;
  String currentDate;
}
