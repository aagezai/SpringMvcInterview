package com.InterviewCompleteJavaSpring.OOP.ThreadInJava.SleepAndWait;

class SharedResource {
    synchronized void doWork() {
        System.out.println(Thread.currentThread().getName() + " is starting the work.");

        try {
            wait(); // Waits for notification
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " resumed the work.");
    }

    synchronized void notifyThread() {

        notify(); // Notifies the waiting thread to resume
    }
}

public class WaitExample {
    public static void main(String[] args) throws InterruptedException {
        SharedResource sharedResource = new SharedResource();
        Thread thread1 = new Thread(() -> sharedResource.doWork(),"Thread 1");// runnable and name of the thread
        Thread thread2 = new Thread(() -> sharedResource.doWork(), "Thread 2");
        thread1.start();
        thread2.start();
        Thread.sleep(500); // Sleep to ensure both threads start since notify is slow
        // Notify one of the waiting threads
        System.out.println("finally ");
        sharedResource.notifyThread(); // Notify one of the waiting threads
        sharedResource.notifyThread();// Notify one of the waiting threads
    }
}
