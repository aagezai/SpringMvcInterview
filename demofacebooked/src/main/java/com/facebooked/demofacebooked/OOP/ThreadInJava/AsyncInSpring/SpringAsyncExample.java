package com.facebooked.demofacebooked.OOP.ThreadInJava.AsyncInSpring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/*@SpringBootApplication*/
public class SpringAsyncExample implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringAsyncExample.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Trigger the asynchronous method
        Future<String> asyncResult = asyncMethod();

        // Continue with other tasks while waiting for the async operation to complete
        System.out.println("Main thread continues with other tasks...");

        // Block and get the result when the async operation is complete
        try {
            String result = asyncResult.get();
            System.out.println("Async operation result: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Async
    public Future<String> asyncMethod() {
        // Simulating a time-consuming operation
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new AsyncResult<>("Async Operation Result");
    }
}
