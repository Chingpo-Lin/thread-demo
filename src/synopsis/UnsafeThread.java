package synopsis;

import java.util.concurrent.CountDownLatch;

public class UnsafeThread {

    private static int num = 0;

    private static CountDownLatch countDownLatch = new CountDownLatch(10);

    public static void inCreate() {
        num++;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i ++) {
            new Thread (() -> {
                for (int j = 0; j < 100; j++) {
                    inCreate();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                countDownLatch.countDown();
            }).start();
        }

        while (true) {
            if (countDownLatch.getCount() == 0) {
                System.out.println(num);
                break;
            }
        }

        System.out.println(num);
    }
}
