import java.util.HashMap;
import java.util.Map;

// 单纯使用哈希表不能找到最久未使用的值, 因此将 value 用双向链表串起来, 维持链表第一个元素是最久未使用的
public class LRUCache {
    private class Node { // 双向链表节点
        public int key;
        public int value;
        public Node prev;
        public Node next;
    
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, Node> map;
    private int capacity;
    private Node head; // 哨兵节点
    private Node tail; // 哨兵节点

    public LRUCache(int capacity) {
        map = new HashMap<Integer, Node>();
        this.capacity = capacity;
        head = new Node(-1, -1); // 记得初始化, 避免空指针异常
        tail = new Node(-1, -1); // 记得初始化, 避免空指针异常
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        removeToTail(node); // 将 key 映射到的链表节点移动到末尾
        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) { // key 存在
            Node node = map.get(key);
            node.value = value;
            removeToTail(node); // 将 key 映射到的链表节点移动到末尾
            return;
        }

        Node node = new Node(key, value); // key 不存在
        if(map.isEmpty() && capacity > 0) { // 初始化哨兵节点即可, 此时插入的唯一节点即在末尾
            node.prev = head;
            node.next = tail;
            head.next = node;
            tail.prev = node;
            map.put(key, node);
        }
        else {
            if(map.size() == capacity) { // 若缓存已满, 先删除链表第一个节点, 即哨兵节点 head 的下一个节点
                map.remove(head.next.key);
                deleteNode(head.next);
            }
            map.put(key, node);
            insertToTail(node); // 将新节点添加到链表末尾
        }
    }

    // helper 以下辅助函数仅改变节点在链表中的指向, 不影响 map 的映射关系
    private void removeToTail(Node node) {
        deleteNode(node);
        insertToTail(node);
    }

    private void insertToTail(Node node) {
        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
    }

    private void deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}