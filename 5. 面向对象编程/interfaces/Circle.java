package interfaces;

/**
 * 实现接口和继承抽象类的具体类
 */
public class Circle extends Shape {
    private double radius;
    private static final double PI = 3.14159;

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a " + color + " circle");
    }

    @Override
    public double getArea() {
        return PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * PI * radius;
    }
} 