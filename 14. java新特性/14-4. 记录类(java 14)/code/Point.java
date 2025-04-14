package code;

public record Point(int x, int y) {
    // 可以添加静态方法或静态字段
    public static Point origin() {
        return new Point(0, 0);
    }
} 