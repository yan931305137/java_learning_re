package code;

public class BatchVirtualThreads {
    public static void main(String[] args) {
        // 批量创建和启动虚拟线程
        for (int i = 0; i < 1000; i++) {
            Thread.startVirtualThread(() -> {
                System.out.println("Task " + Thread.currentThread().getId());
            });
        }
    }
}
