package com.facebooked.demofacebooked.OOP.Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Foo {
    private String message;

    public Foo(String message) {
        this.message = message;
    }

    public void showMessage() {
        System.out.println("Message from Foo: " + message);
    }
}

public class ReflectionCustomExample {
    public static void main(String[] args) {
        // Get the class object for the custom class (Foo)
        Class<?> fooClass = Foo.class;

        // Get information about methods in the class
        Method[] methods = fooClass.getDeclaredMethods();
        System.out.println("Methods in Foo class:");
        for (Method method : methods) {
            System.out.println(method.getName());
        }

        // Get information about fields in the class
        Field[] fields = fooClass.getDeclaredFields();
        System.out.println("\nFields in Foo class:");
        for (Field field : fields) {
            System.out.println(field.getName());
        }

        // Create an instance of the class using reflection
        try {
            Object fooInstance = fooClass.getDeclaredConstructor(String.class).newInstance("Hello, Reflection!");

            // Access the field using reflection
            Field messageField = fooClass.getDeclaredField("message");
            messageField.setAccessible(true);
            String messageValue = (String) messageField.get(fooInstance);
            System.out.println("\nMessage field value: " + messageValue);

            // Invoke a method on the instance
            Method showMessageMethod = fooClass.getDeclaredMethod("showMessage");
            showMessageMethod.invoke(fooInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
