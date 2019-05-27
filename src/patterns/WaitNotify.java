package patterns;

import java.util.Scanner;

public class WaitNotify {

    public void produce() throws InterruptedException {
        synchronized (this) {
            System.out.println("Producer thread running...");
            wait();
            System.out.println("Producer thread resumed");
        }
    }

    public void consume() throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        Thread.sleep(2000);

        synchronized (this) {
            System.out.println("Waiting to press return key");
            scan.nextLine();
            System.out.println("Return key pressed");
            notify();
            Thread.sleep(500);
        }

    }

    public static void main(String[] args) throws InterruptedException {
        final WaitNotify app = new WaitNotify();

        Thread t1 = new Thread(() -> {
            try {
                app.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                app.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start(); t2.start();

        t1.join(); t2.join();
    }

}
