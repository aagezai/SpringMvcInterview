package com.InterviewCompleteJavaSpring.SampleUnitTestController;

import com.InterviewCompleteJavaSpring.AOP_For_Logger.Aop_For_Logger_Class;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(Aop_For_Logger_Class.class);

    @GetMapping("/after")
    public String testAfterAop(){
        return "afterAOP tested check log";
    }
    @GetMapping("/before")
    public String testBeforeAop(){
        int a = 1/0;// exception here
        return "anyString";
    }
}
