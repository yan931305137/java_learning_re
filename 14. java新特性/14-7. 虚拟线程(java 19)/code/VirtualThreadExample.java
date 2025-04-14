package code;

public class VirtualThreadExample {
    public static void main(String[] args) {
        // 创建并启动一个虚拟线程
        Thread.startVirtualThread(() -> {
            System.out.println("Running in a virtual thread");
        });
    }
}
