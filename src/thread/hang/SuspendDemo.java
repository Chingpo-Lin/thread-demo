package thread.hang;

import java.util.Objects;

public class SuspendDemo implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "run execute");
        Thread.currentThread().suspend();
        System.out.println(Thread.currentThread().getName() + "run execute, suspend");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new SuspendDemo());
        thread.start();
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.resume();
    }
}
