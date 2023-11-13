package com.facebooked.demofacebooked.DataStructureInterview.demo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamApiDemo {
    public static void main(String[] args) {
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

        List<Employee> employees = List.of(new Employee(121212L, "E1", 100000, "D1")
                , new Employee(121212L, "E2", 110000, "D2")
                , new Employee(121212L, "E3", 80000, "D3"));
        System.out.println("+++++++ sort list of employee based on salary first then by department\n");
        employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed().thenComparing(Employee::getDepartment))
                .skip(1)
                .forEach(System.out::println);

        System.out.println("++++++++++ find the second and 3rd Employee by salary Custom classifier function: Group by department");
        Map<String, List<Employee>> personsByAge = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment))
                .entrySet()
                .stream()
                .skip(1)
                .limit(2)
                .flatMap(entry -> entry.getValue().stream())
                .collect(Collectors.groupingBy(Employee::getDepartment));

        personsByAge.forEach((dep, em) -> {
            System.out.print("department: " + dep);
            em.forEach(e -> System.out.print("\t" +e));
            System.out.println();
        });

    }
}
