package com.facebooked.demofacebooked.hibernateAndJpaController.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    public static void main(String[] args){
        List<String> list = List.of("ABC","ABCD");
        list.stream().filter(str ->str.length()==3).collect(Collectors.toList()).forEach(el -> System.out.println(el));
    }
}
