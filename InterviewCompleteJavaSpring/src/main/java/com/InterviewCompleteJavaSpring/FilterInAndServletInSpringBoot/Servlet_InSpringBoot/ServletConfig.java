package com.InterviewCompleteJavaSpring.FilterInAndServletInSpringBoot.Servlet_InSpringBoot;


/*
import jakarta.servlet.Filter;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServletConfig implements ServletContextInitializer {

    @Bean
    public FilterRegistrationBean<Filter> loggingFilter() {
        FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new LoggingFilter());
        registrationBean.addUrlPatterns("/api/*");
        registrationBean.setOrder(1);  // Set the order to control the filter execution sequence
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<Filter> authenticationFilter() {
        FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new AuthenticationFilter());
        registrationBean.addUrlPatterns("/api/*");
        registrationBean.setOrder(2);  // Set the order to control the filter execution sequence
        return registrationBean;
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // Nothing to do here if using Spring Boot
    }
}
*/

