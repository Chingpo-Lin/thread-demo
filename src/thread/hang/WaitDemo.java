package thread.hang;

public class WaitDemo implements Runnable{

    private static Object waitObject = new Object();

    @Override
    public void run() {

        synchronized (waitObject) {
            System.out.println(Thread.currentThread().getName() + "resources used");
            try {
                waitObject.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "release resource");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new WaitDemo(), "compare");
        thread.start();

        Thread thread2 = new Thread(new WaitDemo(), "compare");
        thread2.start();
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (waitObject) {
            waitObject.notify();
        }
    }
}
