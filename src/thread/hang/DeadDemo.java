package thread.hang;

public class DeadDemo implements Runnable{

    private static Object object = new Object();

    @Override
    public void run() {

        synchronized (object) {
            System.out.println(Thread.currentThread().getName() + "resources used");
            Thread.currentThread().suspend();
        }
        System.out.println(Thread.currentThread().getName() + "release resource");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new DeadDemo(), "compare");
        thread.start();
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.resume();

        Thread thread2 = new Thread(new DeadDemo(), "compare2");
        thread2.start();
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.resume();
    }
}
