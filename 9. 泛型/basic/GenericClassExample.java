package basic;

/**
 * 泛型类示例
 */
// 基本泛型类
class Box<T> {
    private T content;

    public void set(T content) {
        this.content = content;
    }

    public T get() {
        return content;
    }
}

// 多类型参数的泛型类
class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() { return key; }
    public V getValue() { return value; }
}

public class GenericClassExample {
    public static void main(String[] args) {
        // 使用泛型类
        System.out.println("=== 泛型类示例 ===");
        Box<String> stringBox = new Box<>();
        stringBox.set("Hello Generics");
        System.out.println("String box内容: " + stringBox.get());

        Box<Integer> intBox = new Box<>();
        intBox.set(100);
        System.out.println("Integer box内容: " + intBox.get());

        // 使用多类型参数
        Pair<String, Integer> pair = new Pair<>("Age", 25);
        System.out.println("Pair内容: " + pair.getKey() + " = " + pair.getValue());
    }
} 