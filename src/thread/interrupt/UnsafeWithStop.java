package thread.interrupt;

public class UnsafeWithStop extends Thread{

    private int i = 0;
    private int j = 0;

    @Override
    public void run() {
        i++;
        try {
            sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        j++;
    }

    public void print() {
        System.out.println("i==" + i);
        System.out.println("j==" + j);
    }

    public static void main(String[] args) throws InterruptedException {
        UnsafeWithStop thread = new UnsafeWithStop();
        thread.start();
        Thread.sleep(1000L);
        thread.stop();
        thread.print();
    }
}
