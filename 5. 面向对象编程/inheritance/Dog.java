package inheritance;

/**
 * 继承示例：子类
 */
public class Dog extends Animal {
    private String breed;

    public Dog(String name, int age, String breed) {
        super(name, age); // 调用父类构造器
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Woof! Woof!");
    }

    // 子类特有的方法
    public void fetch() {
        System.out.println(name + " is fetching the ball.");
    }
} 