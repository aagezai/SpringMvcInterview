package com.facebooked.demofacebooked.SpringSecurity.pojo;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
@Component
public class JwtValidationFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;
    private final ObjectMapper mapper;

    public JwtValidationFilter(JwtUtil jwtUtil, ObjectMapper mapper) {
        this.jwtUtil = jwtUtil;
        this.mapper = mapper;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Map<String, Object> errorDetails = new HashMap<>();

        try {
            String accessToken = jwtUtil.resolveToken(request);
            if (accessToken != null) {
                Claims claims = jwtUtil.resolveClaims(request);
                System.out.println("your token is valid");
                String email = claims.getSubject();
                try {
                    Authentication authentication =
                            new UsernamePasswordAuthenticationToken(email, "", new ArrayList<>());
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                } catch (Exception e) {
                    errorDetails.put("message", "Authentication Error");
                    errorDetails.put("details", e.getMessage());
                    response.setStatus(HttpStatus.FORBIDDEN.value());
                    response.setContentType(MediaType.APPLICATION_JSON_VALUE);

                    mapper.writeValue(response.getWriter(), errorDetails);
                    return;
                }
                if (claims == null || !jwtUtil.validateClaims(claims)) {
                    sendErrorResponse(response, HttpStatus.FORBIDDEN, "Invalid or expired token");
                    return;
                }
            }
        } catch (Exception e) {
            errorDetails.put("message", "Token Validation Error");
            errorDetails.put("details", e.getMessage());
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);

            mapper.writeValue(response.getWriter(), errorDetails);
            return;
        }
        filterChain.doFilter(request, response);
    }

    private void sendErrorResponse(HttpServletResponse response, HttpStatus status, String message) throws IOException {
        Map<String, Object> errorDetails = new HashMap<>();
        errorDetails.put("message", message);

        response.setStatus(status.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        mapper.writeValue(response.getWriter(), errorDetails);
    }
}
