package org.personal.gallery.javainternals.core;

import java.util.Scanner;

public class FinallyBlockDemo {
    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        Thread mainThread = Thread.currentThread();
        try{

            int numerator = inputReader.nextInt();
            int denominator = inputReader.nextInt();

            int div = numerator / denominator;
            /**
             *  The interrupt() method is used to interrupt a thread's execution by setting its interrupted flag.
             * It is a more graceful and controlled way to request a thread to stop.
             *  executes finally block
             *
             *
             * The stop() method is used to forcibly terminate a thread's execution. It is a more aggressive and potentially dangerous approach.
             * potentially leaving resources in an inconsistent state
             * doesn't execute finallly block
             *
             * System.exit(non-zero value) does the same as stop().. in both cases finally block doesn't gets executed
             * */
//            mainThread.stop();
            System.exit(10);
//            mainThread.interrupt(); //this is graceful termination
            System.out.println(div);

            while (!Thread.interrupted()) {
                Thread.currentThread().stop();
            }

        }
        catch (ArithmeticException exception){
            System.out.println(exception.getMessage());
        }
        finally {
            //
            /**
             *
             * usage :  Putting cleanup code in a finally block is always a good practice, even when no exceptions are anticipated.
             *
             * So, the finally block gets executed because it's part of the standard try-catch-finally exception handling mechanism
             * in Java, and it ensures that cleanup or resource release code is always executed, even if an exception occurs or if the thread is interrupted.
             * */
            //alternative we can use try with resources block
            inputReader.close();
            System.out.println("cleaned up resources");
        }

    }
}
