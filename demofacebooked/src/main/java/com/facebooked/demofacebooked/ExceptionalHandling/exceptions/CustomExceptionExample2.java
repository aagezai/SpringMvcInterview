package com.facebooked.demofacebooked.ExceptionalHandling.exceptions;

import java.io.IOException;

// Custom exception class
class InvalidInputException extends IOException {
    public InvalidInputException(String message) {
        super(message);
    }
}

public class CustomExceptionExample2 {

    public static void main(String[] args) {
        try {
            processInput("ValidInput");
            processInput("InvalidInput");
        } catch (InvalidInputException e) {
            System.out.println("Caught InvalidInputException: " + e.getMessage());
        }
    }

    // Method that throws the custom exception
    private static void processInput(String input) throws InvalidInputException {
        if ("InvalidInput".equals(input)) {
            throw new InvalidInputException("Invalid input provided");
        }
        System.out.println("Processing input: " + input);
    }
}
