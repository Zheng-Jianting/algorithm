/**
 * 双指针分别指向两个链表, 记两个链表长度相差 k
 * 让指向长链表的指针先走 k 步, 然后以相同速度走, 相遇点即两个链表的交点
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = 0;
        ListNode nodeA = headA;
        while(nodeA != null) {
            lengthA++;
            nodeA = nodeA.next;
        }

        int lengthB = 0;
        ListNode nodeB = headB;
        while(nodeB != null) {
            lengthB++;
            nodeB = nodeB.next;
        }

        ListNode shorter = (lengthA > lengthB) ? headB : headA;
        ListNode longer = (lengthA > lengthB) ? headA : headB;
        int delta = Math.abs(lengthA - lengthB);
        for(int i = 0; i < delta; i++) {
            longer = longer.next;
        }

        while(shorter != null && longer != null && shorter != longer) {
            shorter = shorter.next;
            longer = longer.next;
        }

        return shorter;
    }
}