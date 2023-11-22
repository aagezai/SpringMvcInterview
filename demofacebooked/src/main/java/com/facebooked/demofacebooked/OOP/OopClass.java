package com.facebooked.demofacebooked.OOP;

import com.facebooked.demofacebooked.DataStructureInterview.demo.EmployeeUser;
import com.facebooked.demofacebooked.DataStructureInterview.demo.EmployeeUser;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.stream.IntStream;

public class OopClass implements Cloneable {
    private String string = "private";
     private final String strings ;
     public OopClass(){
         this.strings ="abc";
     }

    public OopClass(String str) {
        this.strings = str;
    }

    public static void main(String[] args) throws CloneNotSupportedException, InterruptedException {
        Object obj = "String";
       if(obj instanceof EmployeeUser){
           EmployeeUser employeeUser = (EmployeeUser) obj;
       }
       //sound of
        Animal animal = new Dog();
        Animal animal1 = new Cat();
       OopClass oopClass = new OopClass();
        OopClass oopClass1 = new OopClass();

       OopClass c = (OopClass) oopClass.clone();
       c.string = "abc";
        System.out.println(oopClass.equals(oopClass1));
        System.out.println(oopClass == oopClass1);
        System.out.println(c.string.equals(oopClass.string));

        //System.out.println(oopClass.getName(animal));
        System.out.println(oopClass.getName(animal1));
        // Note
        // to which we can compare by ==
        // 1, primitive and string lateral
        // to which we can compare by .equals
        //1 instance created by new keyword
        // ex : A a = new A(); A b = new A();
        int a = 4;
        int b =4;
        System.out.println(a==b);
        String aa = null;
        String cc = "abc";

        String bb = new String("abc");
        System.out.println("is allowed" + cc.equals(aa));
        System.out.println("they are not equal" + cc.equals(bb));
        // b.equals(a) gives false// not b == a
        OopClass k = new OopClass();
        OopClass l = k;
        Thread.sleep(5000);
        System.out.println(k.equals(l));
        System.out.println(k == l);

        int[] ints = new int[3];
        IntStream intStream = Arrays.stream(ints);
        intStream.mapToObj(ch ->(char)ch).forEach(System.out::println);

        byte[] byteArray = {65, 66, 67, 68, 69}; // Corresponds to ASCII values for A, B, C, D, E







    }
    public String getName(Animal animal){
        return animal.sound();
    }


}
