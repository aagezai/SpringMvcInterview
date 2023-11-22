package com.facebooked.demofacebooked.OOP;

public interface Animal {
    abstract String sound();

}
class Dog implements Animal{

    @Override
    public String sound() {
        return "WhWh";
    }
}
class Cat implements Animal{

    @Override
    public String sound() {
        return "Mehaw";
    }
}