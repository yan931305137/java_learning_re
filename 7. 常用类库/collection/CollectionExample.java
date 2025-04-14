package collection;

import java.util.*;

/**
 * 集合框架示例
 */
public class CollectionExample {
    public static void main(String[] args) {
        // 1. List示例
        System.out.println("=== List示例 ===");
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");
        System.out.println("List内容: " + list);
        System.out.println("第二个元素: " + list.get(1));

        // 2. Set示例
        System.out.println("\n=== Set示例 ===");
        Set<Integer> hashSet = new HashSet<>();
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(2); // 重复元素不会被添加
        System.out.println("HashSet内容: " + hashSet);

        Set<Integer> treeSet = new TreeSet<>();
        treeSet.add(3);
        treeSet.add(1);
        treeSet.add(2);
        System.out.println("TreeSet内容（已排序）: " + treeSet);

        // 3. Map示例
        System.out.println("\n=== Map示例 ===");
        Map<String, Integer> map = new HashMap<>();
        map.put("Apple", 1);
        map.put("Banana", 2);
        map.put("Orange", 3);
        
        System.out.println("Map内容: " + map);
        System.out.println("Banana的值: " + map.get("Banana"));
        
        // 遍历Map
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // 4. Queue示例
        System.out.println("\n=== Queue示例 ===");
        Queue<String> queue = new LinkedList<>();
        queue.offer("First");
        queue.offer("Second");
        queue.offer("Third");
        
        System.out.println("Queue内容: " + queue);
        System.out.println("取出元素: " + queue.poll());
        System.out.println("现在的Queue: " + queue);

        // 5. PriorityQueue示例
        System.out.println("\n=== PriorityQueue示例 ===");
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(3);
        priorityQueue.offer(1);
        priorityQueue.offer(2);
        
        System.out.println("优先队列内容: " + priorityQueue);
        while (!priorityQueue.isEmpty()) {
            System.out.println("取出: " + priorityQueue.poll());
        }
    }
} 