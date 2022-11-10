package safe;

public class HungerSingleton {

    private static HungerSingleton ourInstance = new HungerSingleton();

    public static HungerSingleton getInstance() {
        return ourInstance;
    }

    // 一定要私有化
    private HungerSingleton() {
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i ++) {
            new Thread(() -> {
                System.out.println(HungerSingleton.getInstance());
            }).start();
        }
    }
}
