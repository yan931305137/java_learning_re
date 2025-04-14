package interfaces;

/**
 * 接口示例
 */
public interface Drawable {
    void draw();
    
    // 默认方法（Java 8+）
    default void display() {
        System.out.println("Displaying the drawable object");
    }
} 