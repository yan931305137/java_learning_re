package code;

public class LambdaSyntaxExample {
    public static void main(String[] args) {
        // 无参数
        Runnable noArgs = () -> System.out.println("Hello, Lambda!");
        noArgs.run();

        // 单个参数
        java.util.function.Function<Integer, Integer> square = x -> x * x;
        System.out.println("Square of 5: " + square.apply(5));

        // 多个参数
        java.util.function.BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        System.out.println("Sum of 3 and 4: " + add.apply(3, 4));

        // 多条语句
        java.util.function.BiFunction<Integer, Integer, Integer> multiply = (a, b) -> {
            int product = a * b;
            return product;
        };
        System.out.println("Product of 3 and 4: " + multiply.apply(3, 4));
    }
} 