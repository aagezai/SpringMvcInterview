package com.facebooked.demofacebooked.ExceptionalHandling.exceptions;

import java.io.IOException;

// Method that declares a checked exception

    // Method that declares a checked exception
    public class CheckedExceptionPropagation {
        public static void main(String[] args) {
            try {
                method1();
            } catch (ClassNotFoundException e) {
                System.out.println("Caught exception: " + e.getMessage());
            }
        }

        // Method that throws a checked exception
        static void method1() throws ClassNotFoundException {
            method2();
        }

        // Another method that throws the same checked exception
        static void method2() throws ClassNotFoundException {
            throw new ClassNotFoundException("Class not found exception");
        }
    }

