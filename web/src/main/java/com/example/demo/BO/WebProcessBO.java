package com.example.demo.BO;

import com.example.demo.VO.LoginVO;
import org.springframework.stereotype.Component;

@Component
public class WebProcessBO {
    public WebProcessBO() {
        System.out.println("inside BO");
    }

    public void process(LoginVO loginVO) {
        System.out.println("inside bo.process");
    }

    public void process() {
    }
}
