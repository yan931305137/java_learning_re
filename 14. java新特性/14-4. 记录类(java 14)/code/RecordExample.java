package code;

public class RecordExample {
    public static void main(String[] args) {
        // 创建记录类对象
        Point point = new Point(3, 4);
        System.out.println("Point: " + point); // 输出: Point[x=3, y=4]

        // 使用自动生成的方法
        System.out.println("X: " + point.x()); // 输出: X: 3
        System.out.println("Y: " + point.y()); // 输出: Y: 4

        // 使用静态方法
        Point origin = Point.origin();
        System.out.println("Origin: " + origin); // 输出: Origin: Point[x=0, y=0]
    }
} 