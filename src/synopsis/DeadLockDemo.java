package synopsis;

public class DeadLockDemo {

    private static final Object HAIR_A = new Object();
    private static final Object HAIR_B = new Object();

    public static void main(String[] args) {

        new Thread(() -> {
            synchronized (HAIR_A) {
                try {
                    Thread.sleep(50L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (HAIR_B) {
                    System.out.println("A catches B");
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (HAIR_B) {
                synchronized (HAIR_A) {
                    System.out.println("B catches A");
                }
            }
        }).start();
    }
}
