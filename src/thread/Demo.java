package thread;

import java.io.IOException;

public class Demo {

    public static void main(String[] args) {
        System.out.println("123");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
