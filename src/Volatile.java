import java.util.Scanner;

class Runner extends Thread {

    private volatile boolean running = true;

    public void run() {
        while(running) {
            System.out.println("Running");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutdown() {
        running = false;
    }

}

public class Volatile {

    public static void main(String[] args) {
        Runner run = new Runner();
        run.start();

        new Scanner(System.in).nextLine();

        run.shutdown();
    }

}
