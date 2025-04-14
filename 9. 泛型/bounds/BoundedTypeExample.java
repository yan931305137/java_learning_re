package bounds;

/**
 * 泛型边界示例
 */
// 单个边界
class NumberBox<T extends Number> {
    private T number;

    public NumberBox(T number) {
        this.number = number;
    }

    public double sqrt() {
        return Math.sqrt(number.doubleValue());
    }
}

// 多个边界
class ComparableBox<T extends Number & Comparable<T>> {
    private T content;

    public ComparableBox(T content) {
        this.content = content;
    }

    public T getMin(T other) {
        if (content.compareTo(other) <= 0) {
            return content;
        }
        return other;
    }
}

public class BoundedTypeExample {
    public static void main(String[] args) {
        // 测试单个边界
        System.out.println("=== 单个边界示例 ===");
        NumberBox<Integer> intBox = new NumberBox<>(16);
        System.out.println("平方根: " + intBox.sqrt());

        NumberBox<Double> doubleBox = new NumberBox<>(2.25);
        System.out.println("平方根: " + doubleBox.sqrt());

        // 测试多个边界
        System.out.println("\n=== 多个边界示例 ===");
        ComparableBox<Integer> box1 = new ComparableBox<>(10);
        System.out.println("最小值: " + box1.getMin(20));

        ComparableBox<Double> box2 = new ComparableBox<>(3.14);
        System.out.println("最小值: " + box2.getMin(2.72));
    }
} 