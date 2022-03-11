import java.util.PriorityQueue;

class Solution {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((i, j) -> lists[i].val - lists[j].val);
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                heap.offer(i);
            }
        }

        ListNode dummy = new ListNode(), cur = dummy;
        while (!heap.isEmpty()) {
            int i = heap.poll();
            cur.next = lists[i];
            ListNode next = lists[i].next;
            lists[i].next = null;
            cur = lists[i];
            lists[i] = next;
            if (lists[i] != null) {
                heap.offer(i);
            }
        }
        return dummy.next;
    }
}