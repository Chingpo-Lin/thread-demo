package thread.priority;

public class PriorityDemo {

    public static void main(String[] args) {
        Thread thread = new Thread(()-> {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName());
            }
        }, "first thread");


        Thread thread2 = new Thread(()-> {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName());
            }
        }, "second thread");

        thread.setPriority(Thread.MIN_PRIORITY);
        thread2.setPriority(Thread.MAX_PRIORITY);
        thread.start();
        thread2.start();
    }
}
