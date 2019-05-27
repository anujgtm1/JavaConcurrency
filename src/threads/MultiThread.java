package threads;

import java.util.Date;

class ThreadRunner extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("i = " + i);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}

class RunnableRunner implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("i = " + i);
        }

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class MultiThread {


    public static void main (String[] args) throws InterruptedException {
        // Multiple threads using Thread class
        System.out.println("Start threads using Thread class");
        System.out.println(new Date());
        ThreadRunner runner1 = new ThreadRunner();
        ThreadRunner runner2 = new ThreadRunner();

        runner1.start(); runner2.start();

        runner1.join(); runner2.join();

        System.out.println(new Date());
        System.out.println("End threads using Thread class");

        // Multiple threads using Runnable interface

        System.out.println("Start threads using Runnable interface");
        System.out.println(new Date());
        Thread t1 = new Thread(new RunnableRunner());
        Thread t2 = new Thread(new RunnableRunner());

        t1.start(); t2.start();

        t1.join();t2.join();

        System.out.println(new Date());
        System.out.println("End threads using Runnable interface");


    }

}
