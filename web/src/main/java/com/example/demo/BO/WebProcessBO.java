package com.example.demo.BO;

import com.example.demo.VO.LoginVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class WebProcessBO {

    public WebProcessBO() {
        System.out.println("inside BO");
    }

    public boolean process(LoginVO loginVO) {
        System.out.println("inside bo.process");
        if(null != loginVO) {
            RestTemplate restTemplate = new RestTemplate();
            String url = "http://127.0.0.1:8083/verify";
            HttpEntity<LoginVO> httpEntity = new HttpEntity<>(loginVO);
            ResponseEntity<Boolean> result  = restTemplate.exchange(url, HttpMethod.POST, httpEntity,Boolean.class );
            if(null != result)
                return result.getBody();
        }
        return false;
    }


}
