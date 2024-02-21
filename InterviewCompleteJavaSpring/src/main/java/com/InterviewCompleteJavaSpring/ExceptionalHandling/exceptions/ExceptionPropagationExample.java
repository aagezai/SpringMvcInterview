package com.InterviewCompleteJavaSpring.ExceptionalHandling.exceptions;

public class ExceptionPropagationExample {

    public static void main(String[] args) {
        try {
            method1();
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught NullPointerException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Caught NullPointerException: " + e.getMessage());
        } catch (Throwable e) {
            System.out.println("Caught NullPointerException: " + e.getMessage());
        }
    }

    private static void method1() {
        try {
            method2();
        } catch (NullPointerException e) {
            // Handling or rethrowing the exception
            System.out.println("Caught NullPointerException in method1: " + e.getMessage());
            throw e; // Rethrow the exception

        }
    }

    private static void method2() {
        // Simulating a situation where a NullPointerException occurs
        String str = null;
        if (str == null) {
            throw new NullPointerException("String is null in method2");
        }
        int length = str.length(); // This line won't be reached if the exception is thrown
    }
}

