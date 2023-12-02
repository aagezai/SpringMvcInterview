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
                , new EmployeeUser(121212L, "E0", 8000, "D3")
                , new EmployeeUser(233334l, "E5", 110000, "D2")
                , new EmployeeUser(12144212L, "E6", 1000000, "D1"));
        System.out.println("+++++++ sort list of employee based on salary first then by department\n");
        employees.stream().sorted(Comparator.comparing(EmployeeUser::getSalary).reversed().thenComparing(EmployeeUser::getDepartment).thenComparing(EmployeeUser::getName))
                /*.skip(1).limit(2)*/.collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("++++Group by Department  ++++++");
        employees.stream().collect(Collectors.groupingBy(EmployeeUser::getDepartment))
                .entrySet()
                .stream()
                .forEach(System.out::println);
        System.out.println(" ++++++ Group by department and get EmployeeUser with max salary for each department");
        Map<String, Optional<EmployeeUser>> maxSalaryEmployeesByDep = employees.stream()
                .collect(Collectors.groupingBy(
                        EmployeeUser::getDepartment,
                        Collectors.maxBy(Comparator.comparingDouble(EmployeeUser::getSalary))
                ));
        // Sort the result by max salary in descending order
        maxSalaryEmployeesByDep.entrySet().stream()
                .sorted((entry1, entry2) ->//(key,vale).stream()
                        entry2.getValue().map(EmployeeUser::getSalary)
                                .orElse(Double.MIN_VALUE)
                                .compareTo(entry1.getValue().map(EmployeeUser::getSalary).orElse(Double.MIN_VALUE)))
                .forEach(System.out::println);
        System.out.println("---------------------------------");

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
        System.out.println("---------------------------------");
        System.out.println("--------------------reverse array of Integer with out sorting-------------");

        Integer[] arr = {4, 1, 9, 3, 2, 9};
        int len = arr.length - 1;
        for (Integer x : arr) {
            if (len >= 0) {
                System.out.print(arr[len]);
                len--;
            }

        }
        System.out.println();
        System.out.println("-----------After converting to list reverse the Array ----------------------");
        Integer[] arr1 = {4, 1, 9, 3, 2, 9};
        List<Integer> re = Arrays.asList(arr1);
        Collections.reverse(re);
        System.out.println(re.toString());

        System.out.println("-----------Fist dupplicate ----------------------");

        List<Integer> dupplicate = List.of(2, 3, 4, 2, 6, 8, 9, 3, 6);
        LinkedHashSet<Integer> first1 = new LinkedHashSet<>();
        for (int i = 0; i <= dupplicate.size() - 1; i++) {
            if (!first1.contains(dupplicate.get(i))) {
                first1.add(i);
            } else {
                System.out.println("this is first duplicate element" + dupplicate.get(i));
                break;
            }
        }
        System.out.println("#################################");
        System.out.println("_________Does traverse or iterate map and modify works? answer No_______");
        Map<Integer,String> mapOfIntAndStr = Map.of(1,"d",3,"b");
        Iterator iterator = mapOfIntAndStr.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer,String> entry = (Map.Entry<Integer, String>) iterator.next();
            System.out.println(entry.getKey()+ " "+entry.getValue());
            //iterator.remove(); //it is not allowed throws concurrent modification exception
        }
        System.out.println("_________Does HashMap reserve the insertion order? ? answer No always _______ but Linked hashmap does ");
        Map<Integer,String> linkedHashMap = new LinkedHashMap<>(mapOfIntAndStr);
        linkedHashMap.entrySet().forEach(System.out::println);
        System.out.println("_________Assume we have Employee (with id and name) create a map with id and name ");
        EmployeeUser e1 = new EmployeeUser(11110L,"namee1",11100.00,"d1");
        EmployeeUser e2 = new EmployeeUser(22210L,"namee2",20000.00,"d2");
        List<EmployeeUser> employeeUserList = List.of(e2,e1);
        employeeUserList.stream().collect(Collectors.toMap(EmployeeUser::getId,EmployeeUser::getName)).forEach((a,b)-> System.out.println(a +" "+b));

    }
}
