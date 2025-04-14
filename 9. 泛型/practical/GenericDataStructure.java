package practical;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/**
 * 泛型数据结构实现示例
 */
// 泛型栈实现
class Stack<E> {
    private List<E> elements = new ArrayList<>();

    public void push(E element) {
        elements.add(element);
    }

    public E pop() {
        if (elements.isEmpty()) {
            throw new EmptyStackException();
        }
        return elements.remove(elements.size() - 1);
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }
}

// 泛型链表节点
class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}

// 泛型链表
class LinkedList<T> {
    private Node<T> head;

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void printList() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

public class GenericDataStructure {
    public static void main(String[] args) {
        // 测试泛型栈
        System.out.println("=== 泛型栈示例 ===");
        Stack<String> stack = new Stack<>();
        stack.push("First");
        stack.push("Second");
        stack.push("Third");

        while (!stack.isEmpty()) {
            System.out.println("弹出: " + stack.pop());
        }

        // 测试泛型链表
        System.out.println("\n=== 泛型链表示例 ===");
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println("链表内容:");
        list.printList();

        LinkedList<String> stringList = new LinkedList<>();
        stringList.add("Hello");
        stringList.add("World");
        System.out.println("字符串链表内容:");
        stringList.printList();
    }
} 