package com.InterviewCompleteJavaSpring.OOP.Async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample {
    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            // Simulating a time-consuming operation
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Async Operation Result";
        });

        // Continue with other tasks while waiting for the async operation to complete
        System.out.println("Main thread continues with other tasks...");

        // Block and get the result when the async operation is complete
        try {
            String result = future.get();
            System.out.println("Async operation result: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
