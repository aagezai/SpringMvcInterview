package com.InterviewCompleteJavaSpring.FilterInAndServletInSpringBoot.Filter_InSpringBoot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @GetMapping("/api/greet")
    public String greet(@RequestParam(required = false) String name) {
        return "Hello, " + (name != null ? name : "Guest") + "!";
    }
}
