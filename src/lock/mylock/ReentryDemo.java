package lock.mylock;

import java.util.concurrent.locks.Lock;

public class ReentryDemo {

    public Lock lock = new MyLock();

    public void methodA() {
        lock.lock();
        System.out.println("enter A");
        methodB();
        lock.unlock();
    }

    public void methodB() {
        lock.lock();
        System.out.println("enter B");
        lock.unlock();
    }

    public static void main (String[] args) {
        ReentryDemo reentryDemo = new ReentryDemo();
        reentryDemo.methodA();
    }
}
