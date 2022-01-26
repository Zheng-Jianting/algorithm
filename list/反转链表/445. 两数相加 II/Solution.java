public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode result = dummy;
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        int carry = 0;
        while(l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int sum = (val1 + val2 + carry) % 10;
            carry = (val1 + val2 + carry) / 10;
            dummy.next = new ListNode(sum);
            dummy = dummy.next;

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if(carry != 0) {
            dummy.next = new ListNode(carry);
        }
        return reverseList(result.next);
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