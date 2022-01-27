import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public Node flatten(Node head) {
        Node prev = null;
        Node cur = head;
        Deque<Node> stack = new LinkedList<>();
        while(cur != null || !stack.isEmpty()) {
            if(cur == null) { // 若当前节点为 null, 则从栈顶弹出一个节点, 将其链接到之前的链表(prev 指针的作用), 然后重复以下操作
                cur = stack.pop();
                prev.next = cur;
                cur.prev = prev;
            }
            if(cur.child != null) { // 若当前节点有子链, 则将其右边的节点压栈, 然后沿着子链走
                if(cur.next != null) {
                    stack.push(cur.next);
                }
                cur.next = cur.child;
                cur.child.prev = cur;
                cur.child = null;
            }
            prev = cur;
            cur = cur.next;
        }
        return head;
    }
}