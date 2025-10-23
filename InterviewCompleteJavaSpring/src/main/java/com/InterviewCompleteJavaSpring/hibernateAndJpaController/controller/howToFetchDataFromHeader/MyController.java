package com.InterviewCompleteJavaSpring.hibernateAndJpaController.controller.howToFetchDataFromHeader;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @GetMapping("/example")
    public String exampleEndpoint(
            @RequestHeader HttpHeaders headers,
            @RequestHeader("Authorization") String authorizationHeader,
            @RequestHeader(name = "User-Agent", defaultValue = "Unknown") String userAgent
    ) {
        // Accessing all headers
        StringBuilder headersInfo = new StringBuilder();
        headersInfo.append("All headers:\n");
        headers.forEach((key, value) -> headersInfo.append(key).append(": ").append(value).append("\n"));

        // Accessing specific headers
        String authHeaderInfo = "Authorization header value: " + authorizationHeader;
        String userAgentInfo = "User-Agent header value: " + userAgent;

        return headersInfo.toString() + "\n" + authHeaderInfo + "\n" + userAgentInfo;
    }
}
