package com.facebooked.demofacebooked.OOP.Reflection;

import java.lang.reflect.Constructor;

class DynamicObject {
    private String message;

    public DynamicObject(String message) {
        this.message = message;
    }

    public void displayMessage() {
        System.out.println("Message from DynamicObject: " + message);
    }
}

public class DynamicObjectCreationExample {
    public static void main(String[] args) {
        // Specify the class name dynamically
        String className = "DynamicObject";

        try {
            // Load the class dynamically
            Class<?> dynamicClass = Class.forName(className);

            // Get the constructor
            Constructor<?> constructor = dynamicClass.getDeclaredConstructor(String.class);

            // Create an instance of the class dynamically
            Object dynamicObject = constructor.newInstance("Hello, Dynamic Creation!");

            // Cast the object to the actual class type
            DynamicObject castedObject = (DynamicObject) dynamicObject;

            // Call a method on the dynamically created object
            castedObject.displayMessage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
