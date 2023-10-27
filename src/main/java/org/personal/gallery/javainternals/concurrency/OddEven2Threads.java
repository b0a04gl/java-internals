package org.personal.gallery.javainternals.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OddEven2Threads {

    static final Object lock = new Object();
    static int number = 0;

    public static void main(String[] args) {


        Runnable runnable = () -> {
            while (number <= 10) {

                synchronized (lock) {

                    System.out.println(Thread.currentThread().getName() + " modified num => " + number);
                    number++;
                    lock.notifyAll();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }

                }

            }
        };



        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(runnable);
        executorService.submit(runnable);

        executorService.shutdown();

    }
}
