package safe;

public class VolatileDemo implements Runnable{

    private static volatile boolean flag = false;
    @Override
    public void run() {
        while (flag) {
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {

    }
}
