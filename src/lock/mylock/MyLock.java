package lock.mylock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class MyLock implements Lock {

    private boolean isHoldLock = false;

    private Thread holdLockThread = null;

    private int reentryCount = 0;
    /**
     * same time, iff one thread get the lock,
     * all other thread need to wait the lock release
     */
    @Override
    public synchronized void lock() {
        if (isHoldLock && Thread.currentThread() != holdLockThread) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        holdLockThread = Thread.currentThread();
        isHoldLock = true;
        reentryCount++;
    }

    @Override
    public synchronized void unlock() {
        // if current thread is lock, yes, count--;
        if (Thread.currentThread() == holdLockThread) {
            reentryCount--;

            if (reentryCount == 0) {
                notify();
                isHoldLock = false;
            }
        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
