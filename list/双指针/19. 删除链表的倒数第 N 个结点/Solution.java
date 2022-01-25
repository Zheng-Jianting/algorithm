public class Solution {
    /**
     * 删除倒数第 n 个节点, 即将倒数第 n+1 个节点的 next 指针指向倒数第 n-1 个节点
     * 通过快慢双指针只遍历一次链表就实现
     * 快指针先移动 n+1 步, 然后慢指针和快指针以相同速度移动直至快指针指向 null
     * 此时两个指针直接距离为 n+1, 慢指针指向倒数第 n+1 个节点
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(); // 哨兵节点
        dummy.next = head;

        ListNode front = head;
        ListNode back = dummy;
        for(int i = 0; i < n; i++) {
            front = front.next;
        }

        while(front != null) {
            front = front.next;
            back = back.next;
        }

        back.next = back.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        // test 1
        ListNode list = new ListNode(1);
        ListNode.append(list, 2);
        ListNode.append(list, 3);
        ListNode.append(list, 4);
        ListNode.append(list, 5);
        ListNode.print(list);
        
        list = new Solution().removeNthFromEnd(list, 2);
        ListNode.print(list);

        // test 2
        list = new ListNode(1);
        ListNode.print(list);
        list = new Solution().removeNthFromEnd(list, 1);
        ListNode.print(list);
    }
}