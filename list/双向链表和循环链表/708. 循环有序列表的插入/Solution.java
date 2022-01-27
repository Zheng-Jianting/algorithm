public class Solution {
    public Node insert(Node head, int insertVal) {
        Node insertNode = new Node(insertVal);
        if(head == null) {
            insertNode.next = insertNode;
            return insertNode;
        }
        if(head.next == head) {
            head.next = insertNode;
            insertNode.next = head;
            return head;
        }

        Node smallest = null;
        Node largest = null;
        Node cur = head;
        int step = 1;
        while(!(cur == head && step > 1)) { // 当 cur 第二次经过 head 时才退出 while
            if(cur.val > cur.next.val) {
                largest = cur;
                smallest = cur.next;
            }
            if(cur.val <= insertVal && insertVal <= cur.next.val) {
                insertNode.next = cur.next;
                cur.next = insertNode;
                return head;
            }
            cur = cur.next;
            step++;

            if(cur.next == head) { // 若在退出循环时还没找到插入的位置, 那么将新节点插入首尾之间, eg: [3, 3, 3] 插入 0
                smallest = smallest == null ? head : smallest;
                largest = largest == null ? cur : largest;
            }
        }
        insertNode.next = smallest;
        largest.next = insertNode;
        return head;
    }
}