package com.facebooked.demofacebooked.OOP.GarbageCollector;

public class FinalizeExample {
    String stringValue = null;
    public static void main(String[] args) {
        // Create an object
        MyObject myObject = new MyObject("Example Object");

        // Make the object eligible for garbage collection
        myObject = null;
        System.gc();// or
        Runtime.getRuntime().gc();
        System.out.println(Runtime.getRuntime().freeMemory());
        System.out.println(Runtime.getRuntime().maxMemory());

        // Allow some time for the garbage collector to run (for demonstration purposes)
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}

class MyObject {
    private String name;

    public MyObject(String name) {
        this.name = name;
    }


}
