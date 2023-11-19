package com.facebooked.demofacebooked.DataStructureInterview.demo;

import java.util.*;
import java.util.stream.Collectors;

public class StreamApiDemo {
    public static void main(String[] strings) {
        System.out.println("convert list of string to list of Characters");

        List.of("AB $C", "DEF", "ABC")
                .stream().flatMapToInt(str -> str.chars())
                .mapToObj(ch -> (char) ch)
                .sorted()
                .collect(Collectors.toList()).forEach(System.out::print);
        System.out.println("\n+++convert list of string to list of Characters and reverse order");
        List.of("ABC", "DEFF", "GHIJ")
                .stream().flatMap(str -> Arrays.stream(str.split("")))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList()).forEach(System.out::print);
        System.out.println("\n+++++++ find non repeated numbers ");
        List.of(5, 3, 6, 6, 2, 7, 7, 4, 1)
                .stream().collect(Collectors.groupingBy(el -> el, Collectors.counting()))
                .entrySet().stream()
                .filter(el -> el.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList())
                .forEach(System.out::print);
        System.out.println("\n +++++get only alphabets from list of words");
        List.of("A@B", "CD#", "2E")
                .stream().map(el -> el.replaceAll("[^a-zA-Z]", ""))
                .collect(Collectors.toList()).forEach(System.out::print);
        System.out.println("\n ++++++++or ---------");
        List.of("A@B", "CD#", "2E").stream()
                .flatMapToInt(el -> el.chars())
                .mapToObj(ch -> (char) ch)
                .filter(e -> Character.isLetter(e))
                .collect(Collectors.toList())
                .forEach(System.out::print);
        System.out.println("\n+++++++++++ find the second and 3rd Employee by salary ");

        List<EmployeeUser> employees = List.of(new EmployeeUser(121212L, "E1", 100000, "D1")
                , new EmployeeUser(121212L, "E2", 110000, "D2")
                , new EmployeeUser(121212L, "E2", 80000, "D3")
                , new EmployeeUser(2342424l, "aron", 90000, "D2"),
                new EmployeeUser(345432l, "Biniam", 130000, "D3"));
        System.out.println("+++++++ sort list of employee based on salary first then by department\n");
        employees.stream().sorted(Comparator.comparing(EmployeeUser::getSalary).reversed().thenComparing(EmployeeUser::getDepartment))
                .skip(1).limit(2).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("++++++++++");
        employees.stream().collect(Collectors.groupingBy(el -> el.getDepartment()))
                .entrySet()
                .stream()
                .flatMap(el -> el.getValue().stream())
                .sorted(Comparator.comparing(EmployeeUser::getSalary).reversed())
                .skip(1)
                .limit(2)
                .collect(Collectors.groupingBy(EmployeeUser::getDepartment))
                .forEach((de, em) -> {
                            System.out.println(de + " " + em);
                        }

                );
        //sort it using lambda Comparator
        Comparator<EmployeeUser> comparator = (e1, e2) -> {
            int result;
            if (e1.getSalary() < e2.getSalary())
                result = -1;
            else if (e1.getSalary() > e2.getSalary())
                result = 1;
            else
                result = 0;
            return result;
        };
        Comparator<EmployeeUser> comparator11 = (e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary());
        employees.stream().sorted(comparator11).collect(Collectors.toList())
                .forEach(el -> System.out.println(el));
        Comparator<EmployeeUser> comparator22 = Comparator.comparingDouble(EmployeeUser::getSalary);
        employees.stream().sorted(comparator22).collect(Collectors.toList())
                .forEach(el -> System.out.println(el));
    }
}
