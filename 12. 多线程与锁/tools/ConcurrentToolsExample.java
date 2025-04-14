package tools;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 并发工具类示例
 */
public class ConcurrentToolsExample {
    public static void main(String[] args) throws Exception {
        // 1. CountDownLatch示例
        CountDownLatch latch = new CountDownLatch(3);
        for(int i = 0; i < 3; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + "完成任务");
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        latch.await();
        System.out.println("所有任务完成");
        
        // 2. CyclicBarrier示例
        CyclicBarrier barrier = new CyclicBarrier(3, () -> 
            System.out.println("所有线程到达栅栏点")
        );
        
        for(int i = 0; i < 3; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + "到达栅栏");
                    barrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
        
        // 3. Semaphore示例
        Semaphore semaphore = new Semaphore(2);
        for(int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "获得许可");
                    Thread.sleep(1000);
                    semaphore.release();
                    System.out.println(Thread.currentThread().getName() + "释放许可");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        
        // 4. AtomicInteger示例
        AtomicInteger atomicInt = new AtomicInteger(0);
        for(int i = 0; i < 3; i++) {
            new Thread(() -> {
                for(int j = 0; j < 1000; j++) {
                    atomicInt.incrementAndGet();
                }
            }).start();
        }
        
        Thread.sleep(1000);
        System.out.println("AtomicInteger最终值: " + atomicInt.get());
    }
} 