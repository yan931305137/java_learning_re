package basic;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 线程创建示例
 */
public class ThreadCreationExample {
    
    // 1. 继承Thread类
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Thread方式：" + Thread.currentThread().getName());
        }
    }
    
    // 2. 实现Runnable接口
    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("Runnable方式：" + Thread.currentThread().getName());
        }
    }
    
    // 3. 实现Callable接口
    static class MyCallable implements Callable<String> {
        @Override
        public String call() throws Exception {
            return "Callable方式：" + Thread.currentThread().getName();
        }
    }
    
    public static void main(String[] args) throws Exception {
        // 使用Thread类
        Thread thread1 = new MyThread();
        thread1.start();
        
        // 使用Runnable接口
        Thread thread2 = new Thread(new MyRunnable());
        thread2.start();
        
        // 使用Callable接口
        FutureTask<String> futureTask = new FutureTask<>(new MyCallable());
        Thread thread3 = new Thread(futureTask);
        thread3.start();
        System.out.println(futureTask.get()); // 获取返回值
    }
} 