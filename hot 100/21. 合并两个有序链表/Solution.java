class Solution {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(), cur = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                ListNode next = list1.next;
                list1.next = null;
                cur = list1;
                list1 = next;
            } else {
                cur.next = list2;
                ListNode next = list2.next;
                list2.next = null;
                cur = list2;
                list2 = next;
            }
        }
        if (list1 != null) {
            cur.next = list1;
        } else if (list2 != null) {
            cur.next = list2;
        }
        return dummy.next;
    }
}