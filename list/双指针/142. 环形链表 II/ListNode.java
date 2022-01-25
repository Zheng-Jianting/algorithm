public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static ListNode append(ListNode head, int val) {
        ListNode dummy = new ListNode(); // 哨兵节点, 避免单独判断 head == null 的情况
        dummy.next = head;

        ListNode node = dummy;
        while(node.next != null) {
            node = node.next;
        }

        node.next = new ListNode(val);
        // return dummy.next;
        return node.next;
    }

    public static ListNode delete(ListNode head, int val) {
        ListNode dummy = new ListNode(); // 哨兵节点, 避免单独判断 head == null 的情况以及删除的节点为 head 的情况
        dummy.next = head;

        ListNode node = dummy;
        while(node.next != null) { // node 指向第 i 个节点时, 判断的是第 i+1 个节点符不符合删除条件, 因此 head 节点是没被遍历到的, 哨兵节点可以简化删除操作
            if(node.next.val == val) {
                node.next = node.next.next;
                break;
            }
            node = node.next;
        }

        return dummy.next;
    }

    public static void print(ListNode head) {
        StringBuilder s = new StringBuilder();
        ListNode node = head;
        while(node != null) {
            s.append(node.val + " ");
            node = node.next;
        }
        System.out.println(s.toString());
    }
}