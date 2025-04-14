package inheritance;

/**
 * 继承示例：父类
 */
public abstract class Animal {
    protected String name;
    protected int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 抽象方法
    public abstract void makeSound();

    // 具体方法
    public void eat() {
        System.out.println(name + " is eating.");
    }

    public void sleep() {
        System.out.println(name + " is sleeping.");
    }
} 