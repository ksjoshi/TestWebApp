package com.example.demo.bo;

import com.example.demo.vo.RegisterUser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class WebProcessBoTest {


  private static final String url = "http://127.0.0.1:8083/register";
  @MockBean
  HttpEntity httpEntity;
  private RestTemplate restTemplate = mock(RestTemplate.class);
  private final WebProcessBO subject = new WebProcessBO(restTemplate);
  private RegisterUser input = new RegisterUser(
          "uName", "fName", "lName", "pwd", "hint"
  );

  @Test
  void shouldRegisterProvidedUser() {
    ResponseEntity<Integer> responseEntity = new ResponseEntity<>(1, HttpStatus.OK);
    HttpEntity<RegisterUser> httpEntity = new HttpEntity<>(input);
    when(restTemplate.exchange(
            eq(url),
            eq(HttpMethod.POST),
            eq(httpEntity),
            eq(Integer.class))
    ).thenReturn(responseEntity);

    Integer actual = subject.registerUser(input);
    verify(restTemplate).exchange(url,
            HttpMethod.POST,
            httpEntity,
            Integer.class);
    assertThat(actual).isEqualTo(1);
  }

  @Test
  void shouldReturn0IfRegisterUserGetsError() {
    HttpEntity<RegisterUser> httpEntity = new HttpEntity<>(input);
    when(restTemplate.exchange(
            eq(url),
            eq(HttpMethod.POST),
            eq(httpEntity),
            eq(Integer.class))
    ).thenReturn(null);

    Integer actual = subject.registerUser(input);
    verify(restTemplate).exchange(url,
            HttpMethod.POST,
            httpEntity,
            Integer.class);
    assertThat(actual).isEqualTo(0);
  }
}