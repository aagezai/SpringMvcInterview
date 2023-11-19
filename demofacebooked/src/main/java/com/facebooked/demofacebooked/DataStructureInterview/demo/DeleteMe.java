package com.facebooked.demofacebooked.DataStructureInterview.demo;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DeleteMe {
   public static void main(String args[]) {
      System.out.println("convert list of string to list of Characters");
      List.of("AB $C", "DEF", "ABC")
              .stream().flatMapToInt(str->str.chars())
              .mapToObj(ch->(char)ch)
              .sorted()
              .collect(Collectors.toList())
              .forEach(System.out::println);

      System.out.println("**********************");
      List.of("AB $C", "DEF", "ABC")
              .stream()
              .flatMapToInt(str->str.replaceAll("[^a-zA-Z]"," ").chars())
              .mapToObj(ch->(char)ch)

              .sorted()
              .forEach(System.out::println);

      System.out.println("\n+++convert list of string to list of Characters and reverse order");
      List.of("ABC", "DEFF", "GHIJ")
              .stream()
              .flatMapToInt(str->str.chars())
              .mapToObj(ch->(char)ch)
              .sorted(Comparator.reverseOrder())
              .collect(Collectors.toList())
              .forEach(System.out::println);
      System.out.println("\n+++++++ find non repeated numbers ");
      List.of(5, 3, 6, 6, 2, 7, 7, 4, 1)
              .stream()
              .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
              .entrySet()
              .stream()
              .filter(x->x.getValue()==1)
             // .map(Map.Entry::getKey)
              .collect(Collectors.toList())
              .forEach(System.out::println);
      System.out.println("\n +++++get only alphabets from list of words");
      List.of("A@B", "CD#", "2E")
              .stream()
              .flatMapToInt(str->str.replaceAll("[^a-zA-z]","").chars())
              .mapToObj(ch->(char)ch)
              .forEach(System.out::println);
      System.out.println("\n+++++++++++ find the second and 3rd Employee by salary ");

      List<EmployeeUser> employees = List.of(new EmployeeUser(121212L, "E1", 100000, "D1")
              , new EmployeeUser(121212L, "E2", 110000, "D2")
              , new EmployeeUser(121212L, "E2", 80000, "D3")
      ,new EmployeeUser(233334l,"E5",90000,"D2"));
      System.out.println("+++++++ sort list of employee based on salary first then by department\n");
         employees.stream().sorted(Comparator.comparing(EmployeeUser::getSalary).reversed().thenComparing(EmployeeUser::getDepartment))
                 .skip(1)
                 .limit(2)
                 .forEach(System.out::println);
      System.out.println("+++++++ sort list of employee based on salary first then by department from FRIST FROM DEPARTMENTS THEN THE 2 HIGHEST" +
              "\n");

      employees.stream()
              .collect(Collectors.groupingBy(el->el.getDepartment()))
              .entrySet()
              .stream()
              .flatMap(em->em.getValue().stream().sorted(Comparator.comparing(employeeUser -> employeeUser.getSalary())))
//              .skip(1)
//              .limit(2)
// this completd chech it

              .forEach(System.out::println);



   }

}
