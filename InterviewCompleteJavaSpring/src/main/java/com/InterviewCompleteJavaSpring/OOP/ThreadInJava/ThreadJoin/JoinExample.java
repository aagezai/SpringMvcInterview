package com.InterviewCompleteJavaSpring.OOP.ThreadInJava.ThreadJoin;
public class JoinExample {
    private Runnable runnable = () -> {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
            // Thread.sleep(500); // Simulating some work
        }
    };
    public static void main(String[] args) throws InterruptedException {
        // Creating two threads
        JoinExample joinExample = new JoinExample();
        Thread thread0 = new Thread(joinExample.runnable);
        Thread thread1 = new Thread(joinExample.runnable);
        Thread thread2 = new Thread(joinExample.runnable);
        // Using join to wait for thread1 to complete before proceeding
        // Start thread 1 and continue until it finishes its task
        thread0.start();
        System.out.println("skdfjsdalkfjsdflk");
        thread0.join();
        thread1.start();
        System.out.println("Thread0 has completed. Main thread continues.");
        // Using join with a timeout (in milliseconds) to wait for thread2 to complete
        thread1.join();
        thread2.start();
        System.out.println("Thread1 has completed. Main thread continues.");
        thread2.join();
        System.out.println("Thread1 has completed or the timeout has occurred. Main thread continues.");
        System.out.println("Main thread completes. and all threads by thread1");
    }
}
