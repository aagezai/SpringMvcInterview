package com.InterviewCompleteJavaSpring.FilterInAndServletInSpringBoot.Filter_InSpringBoot;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import java.io.IOException;

public class LoggingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code, if needed
        System.out.println("LoggingFilter initialization completed");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // Pre-processing tasks before the servlet is invoked
        System.out.println("LoggingFilter: Pre-processing request");

        // Continue the request/response chain
        chain.doFilter(request, response);

        // Post-processing tasks after the servlet has been invoked
        System.out.println("LoggingFilter: Post-processing response");
    }

    @Override
    public void destroy() {
        // Cleanup code, if needed
        System.out.println("LoggingFilter is being destroyed");
    }
}
