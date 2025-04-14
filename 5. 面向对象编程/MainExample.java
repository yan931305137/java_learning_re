import basic.Person;
import inheritance.Dog;
import interfaces.Circle;
import enums.Season;

/**
 * 主类：展示各种面向对象特性的使用
 */
public class MainExample {
    public static void main(String[] args) {
        // 1. 基础类使用示例
        System.out.println("=== 基础类示例 ===");
        Person person1 = new Person("张三", 25);
        Person person2 = new Person("李四", 30);
        System.out.println(person1);
        System.out.println("总人数：" + Person.getCount());

        // 2. 继承和多态示例
        System.out.println("\n=== 继承和多态示例 ===");
        Dog dog = new Dog("旺财", 3, "金毛");
        dog.makeSound();
        dog.eat();
        dog.fetch();

        // 3. 接口和抽象类示例
        System.out.println("\n=== 接口和抽象类示例 ===");
        Circle circle = new Circle("红色", 5.0);
        circle.draw();
        System.out.println("圆的面积：" + circle.getArea());
        System.out.println("圆的周长：" + circle.getPerimeter());

        // 4. 枚举类型示例
        System.out.println("\n=== 枚举类型示例 ===");
        for (Season season : Season.values()) {
            System.out.printf("%s（%s）的平均温度是 %d 度\n", 
                season.name(), 
                season.getChineseName(), 
                season.getAverageTemp());
        }

        // 5. 内部类示例
        class LocalClass {
            public void display() {
                System.out.println("这是一个局部内部类");
            }
        }
        new LocalClass().display();
    }
} 