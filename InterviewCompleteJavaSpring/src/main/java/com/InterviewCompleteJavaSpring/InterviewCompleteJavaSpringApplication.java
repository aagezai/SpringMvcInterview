package com.InterviewCompleteJavaSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@EnableAspectJAutoProxy
public class InterviewCompleteJavaSpringApplication {
	public static void main(String[] args) {
		SpringApplication.run(InterviewCompleteJavaSpringApplication.class, args);
	}

}
