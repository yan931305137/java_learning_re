package pool;

import java.util.concurrent.*;

/**
 * 线程池示例
 */
public class ThreadPoolExample {
    public static void main(String[] args) {
        // 1. 固定大小线程池
        ExecutorService fixedPool = Executors.newFixedThreadPool(3);
        
        // 2. 缓存线程池
        ExecutorService cachedPool = Executors.newCachedThreadPool();
        
        // 3. 单线程池
        ExecutorService singlePool = Executors.newSingleThreadExecutor();
        
        // 4. 调度线程池
        ScheduledExecutorService scheduledPool = Executors.newScheduledThreadPool(2);
        
        // 使用固定线程池执行任务
        for(int i = 0; i < 5; i++) {
            final int taskId = i;
            fixedPool.execute(() -> {
                System.out.println("固定线程池-任务" + taskId + 
                                 "由线程" + Thread.currentThread().getName() + "执行");
            });
        }
        
        // 使用调度线程池执行定时任务
        scheduledPool.scheduleAtFixedRate(() -> {
            System.out.println("调度任务由线程" + Thread.currentThread().getName() + "执行");
        }, 0, 2, TimeUnit.SECONDS);
        
        // 关闭线程池
        fixedPool.shutdown();
        cachedPool.shutdown();
        singlePool.shutdown();
        // scheduledPool.shutdown(); // 注释掉以便观察定时任务执行
    }
} 