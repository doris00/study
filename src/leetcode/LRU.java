package leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LinkedHashMap + 双向链表
 */
public class LRU {
    class Node{
        int key;
        int value;
        Node prev;
        Node next;
        Node(){}
        Node(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }

    private Map<Integer, Node> cache = new HashMap<>();
    private int size;
    private int capacity;
    private Node head, tail;

    public LRU(int capacity){
        this.size = 0;
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node == null) {
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            ++size;
            if(size > capacity) {
                Node tail = removeTail();
                cache.remove(tail.key);
                --size;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void addToHead(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private  void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    private Node removeTail() {
        Node node = tail.prev;
        removeNode(node);
        return node;
    }
    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }
}
