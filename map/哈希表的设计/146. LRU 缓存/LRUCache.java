import java.util.HashMap;
import java.util.Map;

// 单纯使用哈希表不能找到最久未使用的值, 因此将 value 用双向链表串起来, 维持链表第一个元素是最久未使用的
class LRUCache {
    static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int capacity;
    Node head;
    Node tail;
    Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;

        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        moveToTail(map.get(key));
        return map.get(key).value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.get(key).value = value;
            moveToTail(map.get(key));
            return;
        }

        if (map.size() >= capacity) {
            map.remove(head.next.key);
            deleteNode(head.next);
        }

        map.put(key, new Node(key, value));
        insertToTail(map.get(key));
    }

    private void moveToTail(Node node) {
        deleteNode(node);
        insertToTail(node);
    }

    private void deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertToTail(Node node) {
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
    }
}