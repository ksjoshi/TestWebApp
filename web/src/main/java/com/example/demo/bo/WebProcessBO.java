package com.example.demo.bo;

import com.example.demo.vo.LoginVO;
import com.example.demo.vo.RegisterUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class WebProcessBO {

  private RestTemplate restTemplate;

  public WebProcessBO(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
    System.out.println("inside BO");
  }

  public boolean process(LoginVO loginVO) {
    System.out.println("inside bo.process");
    if (null != loginVO) {
      //RestTemplate restTemplate = new RestTemplate();
      String url = "http://127.0.0.1:8083/verify";
      HttpEntity<LoginVO> httpEntity = new HttpEntity<>(loginVO);
      ResponseEntity<Boolean> result = restTemplate.exchange
              (url, HttpMethod.POST, httpEntity, Boolean.class);
      if (null != result) {
        return result.getBody();
      }
    }
    return false;
  }

  public int registerUser(RegisterUser registerUser) {
    log.debug("inside register User - {}", registerUser);
    //RestTemplate restTemplate = new RestTemplate();
    String url = "http://127.0.0.1:8083/register";
    HttpEntity<RegisterUser> httpEntity = new HttpEntity<>(registerUser);
    ResponseEntity<Integer> result = restTemplate.exchange(url, HttpMethod.POST, httpEntity, Integer.class);
    return result != null ? result.getBody() : 0;
  }


}
