public class Solution {
    public void reorderList(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        // 快慢指针将链表分割成两部分: 前半部分长度 >= 后半部分长度, 并且将后半部分链表反转
        ListNode slow = dummy;
        ListNode fast = head;
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
            if(fast != null) {
                fast = fast.next;
            }
        }

        ListNode secondHalf = reverseList(slow.next);
        slow.next = null;
        ListNode firstHalf = head;

        /**
         * eg: firstHalf:   1 -> 2 -> 3 -> 4
         *     secondHalf:  7 -> 6 -> 5
         * 第一次迭代: 1 -> 7; 7 -> 2;
         * 第二次迭代: 2 -> 6; 6 -> 3; 以此类推
         * 由于改变指针指向导致下一个节点丢失, 因此每次迭代需要先保存下一个节点
         */
        while(secondHalf != null) {
            ListNode firstNext = firstHalf.next;
            ListNode secondNext = secondHalf.next;

            firstHalf.next = secondHalf;
            secondHalf.next = firstNext;

            firstHalf = firstNext;
            secondHalf = secondNext;
        }
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}