package lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Lock接口示例
 */
public class LockExample {
    private final Lock lock = new ReentrantLock();
    private final ReadWriteLock rwLock = new ReentrantReadWriteLock();
    private int count = 0;
    
    // 使用ReentrantLock
    public void increment() {
        lock.lock();
        try {
            count++;
            System.out.println(Thread.currentThread().getName() + ": " + count);
        } finally {
            lock.unlock();
        }
    }
    
    // 使用ReadWriteLock - 读操作
    public void read() {
        rwLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " 读取值: " + count);
            Thread.sleep(1000); // 模拟读取操作
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            rwLock.readLock().unlock();
        }
    }
    
    // 使用ReadWriteLock - 写操作
    public void write(int value) {
        rwLock.writeLock().lock();
        try {
            count = value;
            System.out.println(Thread.currentThread().getName() + " 写入值: " + value);
            Thread.sleep(1000); // 模拟写入操作
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            rwLock.writeLock().unlock();
        }
    }
    
    public static void main(String[] args) {
        LockExample example = new LockExample();
        
        // 测试ReentrantLock
        for(int i = 0; i < 3; i++) {
            new Thread(() -> example.increment()).start();
        }
        
        // 测试ReadWriteLock
        for(int i = 0; i < 3; i++) {
            new Thread(() -> example.read()).start();
        }
        
        new Thread(() -> example.write(10)).start();
    }
} 