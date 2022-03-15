class Solution {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
    }

    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head, fast = head, slowPrev = null;
        while (fast != null) {
            slowPrev = slow;
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        slowPrev.next = null;

        ListNode head1 = head, head2 = slow;
        head1 = mergeSort(head1);
        head2 = mergeSort(head2);

        ListNode dummy = new ListNode(), cur = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                cur.next = head1;
                ListNode next = head1.next;
                head1.next = null;
                cur = cur.next;
                head1 = next;
            } else {
                cur.next = head2;
                ListNode next = head2.next;
                head2.next = null;
                cur = cur.next;
                head2 = next;
            }
        }
        if (head1 != null) {
            cur.next = head1;
        }
        if (head2 != null) {
            cur.next = head2;
        }
        
        return dummy.next;
    }
}