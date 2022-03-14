public class Solution {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
    }

    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
            if (slow != null && slow == fast) {
                return true;
            }
        }
        return false;
    }
}