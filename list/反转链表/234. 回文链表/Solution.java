public class Solution {
    public boolean isPalindrome(ListNode head) {
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

        while(secondHalf != null) {
            if(firstHalf.val != secondHalf.val) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
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