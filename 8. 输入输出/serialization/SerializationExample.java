package serialization;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * 序列化示例
 */
class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    private transient String password; // transient字段不会被序列化

    public Person(String name, int age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + 
               ", password='" + password + "'}";
    }
}

public class SerializationExample {
    public static void main(String[] args) {
        try {
            // 1. 序列化对象
            System.out.println("=== 序列化示例 ===");
            Person person = new Person("张三", 25, "secret123");
            System.out.println("原始对象：" + person);
            
            // 写入对象
            try (ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream("person.ser"))) {
                oos.writeObject(person);
                System.out.println("对象已序列化");
            }
            
            // 2. 反序列化对象
            System.out.println("\n=== 反序列化示例 ===");
            try (ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream("person.ser"))) {
                Person deserializedPerson = (Person) ois.readObject();
                System.out.println("反序列化后的对象：" + deserializedPerson);
            }
            
            // 清理文件
            Files.deleteIfExists(Paths.get("person.ser"));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
} 