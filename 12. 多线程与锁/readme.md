# Java 多线程与锁机制

## 1. 线程基础
### 1.1 什么是线程
- 线程是程序执行的最小单位
- 一个进程可以包含多个线程
- 线程共享进程的资源

### 1.2 线程的生命周期
1. NEW（新建）
2. RUNNABLE（可运行）
3. BLOCKED（阻塞）
4. WAITING（等待）
5. TIMED_WAITING（计时等待）
6. TERMINATED（终止）

## 2. 线程的创建与使用
### 2.1 创建线程的方式
1. 继承Thread类
```java
class MyThread extends Thread {
    public void run() {
        // 线程执行代码
    }
}
```

2. 实现Runnable接口
```java
class MyRunnable implements Runnable {
    public void run() {
        // 线程执行代码
    }
}
```

3. 实现Callable接口（有返回值）
```java
class MyCallable implements Callable<String> {
    public String call() throws Exception {
        return "结果";
    }
}
```

### 2.2 线程的常用方法
- `start()`: 启动线程
- `run()`: 线程执行体
- `sleep()`: 线程休眠
- `join()`: 等待线程结束
- `interrupt()`: 中断线程
- `yield()`: 让出CPU时间片

## 3. 线程同步
### 3.1 synchronized关键字
1. 同步方法
```java
public synchronized void method() {
    // 同步代码
}
```

2. 同步代码块
```java
synchronized(object) {
    // 同步代码
}
```

### 3.2 Lock接口
1. ReentrantLock（可重入锁）
```java
Lock lock = new ReentrantLock();
lock.lock();
try {
    // 临界区代码
} finally {
    lock.unlock();
}
```

2. ReadWriteLock（读写锁）
- ReadLock：共享锁
- WriteLock：排他锁

## 4. 线程通信
### 4.1 等待/通知机制
- `wait()`: 等待
- `notify()`: 通知单个线程
- `notifyAll()`: 通知所有线程

### 4.2 Condition接口
- `await()`: 等待
- `signal()`: 通知
- `signalAll()`: 通知所有

## 5. 线程池
### 5.1 常用线程池
1. FixedThreadPool：固定大小线程池
2. CachedThreadPool：缓存线程池
3. SingleThreadExecutor：单线程池
4. ScheduledThreadPool：调度线程池

### 5.2 线程池参数
- corePoolSize：核心线程数
- maximumPoolSize：最大线程数
- keepAliveTime：线程存活时间
- workQueue：工作队列
- threadFactory：线程工厂
- handler：拒绝策略

## 6. 并发工具类
### 6.1 CountDownLatch
- 用于等待多个线程完成
- `countDown()`: 计数减一
- `await()`: 等待计数为零

### 6.2 CyclicBarrier
- 循环栅栏
- 等待多个线程到达某个点
- 可重用

### 6.3 Semaphore
- 信号量
- 控制并发访问数量
- 常用于资源池管理

## 7. 原子类
### 7.1 基本类型原子类
- AtomicInteger
- AtomicLong
- AtomicBoolean

### 7.2 数组原子类
- AtomicIntegerArray
- AtomicLongArray
- AtomicReferenceArray

### 7.3 引用原子类
- AtomicReference
- AtomicStampedReference
- AtomicMarkableReference

## 8. 锁机制详解
### 8.1 synchronized
- 对象锁
- 类锁
- 可重入性
- 自动释放

### 8.2 Lock体系
1. ReentrantLock特性
   - 可中断
   - 可超时
   - 公平性选择
   - 可重入性

2. ReadWriteLock特性
   - 读写分离
   - 写锁独占
   - 读锁共享

## 9. 线程安全集合
### 9.1 并发容器
- ConcurrentHashMap
- CopyOnWriteArrayList
- ConcurrentLinkedQueue
- BlockingQueue实现类

### 9.2 同步包装器
- Collections.synchronizedList()
- Collections.synchronizedSet()
- Collections.synchronizedMap()

## 10. 最佳实践
### 10.1 性能优化
- 避免锁竞争
- 合理使用线程池
- 选择适当的并发容器

### 10.2 死锁预防
- 固定加锁顺序
- 避免嵌套锁
- 使用超时锁

### 10.3 线程安全设计
- 不可变对象
- 线程封闭
- 同步策略

## 11. 常见问题
### 11.1 并发问题
- 竞态条件
- 内存可见性
- 指令重排序

### 11.2 性能问题
- 上下文切换
- 锁竞争
- 资源耗尽

### 11.3 调试技巧
- 线程转储分析
- 死锁检测
- 性能分析工具 