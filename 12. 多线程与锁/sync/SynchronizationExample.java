package sync;

/**
 * 同步机制示例
 */
public class SynchronizationExample {
    private int count = 0;
    private final Object lock = new Object();
    
    // 1. synchronized方法
    public synchronized void incrementSync() {
        count++;
        System.out.println(Thread.currentThread().getName() + ": " + count);
    }
    
    // 2. synchronized代码块
    public void incrementBlock() {
        synchronized(lock) {
            count++;
            System.out.println(Thread.currentThread().getName() + ": " + count);
        }
    }
    
    // 3. 等待/通知机制
    public synchronized void produce() throws InterruptedException {
        while(count >= 5) {
            wait();  // 等待消费者消费
        }
        count++;
        System.out.println("生产者生产，当前数量：" + count);
        notifyAll();  // 通知消费者
    }
    
    public synchronized void consume() throws InterruptedException {
        while(count <= 0) {
            wait();  // 等待生产者生产
        }
        count--;
        System.out.println("消费者消费，当前数量：" + count);
        notifyAll();  // 通知生产者
    }
    
    public static void main(String[] args) {
        SynchronizationExample example = new SynchronizationExample();
        
        // 测试同步方法
        for(int i = 0; i < 3; i++) {
            new Thread(() -> {
                example.incrementSync();
            }).start();
        }
        
        // 测试生产者-消费者
        Thread producer = new Thread(() -> {
            try {
                for(int i = 0; i < 5; i++) {
                    example.produce();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        
        Thread consumer = new Thread(() -> {
            try {
                for(int i = 0; i < 5; i++) {
                    example.consume();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        
        producer.start();
        consumer.start();
    }
} 