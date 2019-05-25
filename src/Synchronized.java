
public class Synchronized {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public void run() {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                increment();
            }
        });
        t1.start();
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                increment();
            }
        });
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("count = " + count);
    }

    public static void main(String[] args) {
        Synchronized app = new Synchronized();
        app.run();
    }

}
