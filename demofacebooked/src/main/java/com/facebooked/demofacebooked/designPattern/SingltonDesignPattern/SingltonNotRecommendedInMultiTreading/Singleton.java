package com.facebooked.demofacebooked.designPattern.SingltonDesignPattern.SingltonNotRecommendedInMultiTreading;

public class Singleton {
    private static Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
    public void showSingleton(){
        System.out.println(" you are in singleton");
    }
}
