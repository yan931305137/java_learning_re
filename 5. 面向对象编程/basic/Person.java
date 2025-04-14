package basic;

/**
 * 基础类示例：展示类的基本结构、封装、构造方法等
 */
public class Person {
    // 私有属性（封装）
    private String name;
    private int age;
    private static int count = 0; // 静态成员

    // 构造方法
    public Person() {
        count++;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        count++;
    }

    // getter和setter方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 0 && age <= 150) {
            this.age = age;
        }
    }

    // 静态方法
    public static int getCount() {
        return count;
    }

    // 重写Object类的方法
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return age == person.age && 
               (name == null ? person.name == null : name.equals(person.name));
    }
} 