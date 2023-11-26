package com.facebooked.demofacebooked.DataStructureInterview.demo;



import java.util.*;
import java.util.stream.Collectors;


public class DeleteMe {
    public static void main(String args[]) {
        List<String> list = List.of("bb", "ww");
        Iterator<String> iterator = list.iterator();

        List<String> namesList = List.of( "Red", "Blue", "Green" );
        List<Integer> x=List.of(2,3,3,4,5);
        int[] y=new int[x.size()];
        for (int i=0;i<y.length;i++){
            y[i]=x.get(i);

        }
        System.out.println(Arrays.toString(y));
        namesList.stream().filter(str->str.length()<4).collect(Collectors.toList())
                .forEach(System.out::println);
        // Using peek to filter and print odd numbers
        System.out.println("---------------------------------");
        List<Integer> numbers = Arrays.asList(1, 2, 3,3,4, 4, 5);
//        List<Integer> oddNumbers = numbers.stream()
//                .filter(n -> n % 2 != 0)
//                .peek(System.out::println)
//                .collect(Collectors.toList());

    Set<Integer> set=new HashSet<>(numbers);
    Set<Integer> treeSet=new TreeSet<>();
    treeSet.addAll(numbers);
        System.out.println(treeSet);

        System.out.println(set);

        Map<Integer,Integer> treemap=new HashMap();
        treemap.put(null,5);
        treemap.put(null,4);
        System.out.println(treemap);




        int[] array = x.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(array));
        List<Integer> collect = Arrays.stream(array).boxed().collect(Collectors.toList());
    }


}


