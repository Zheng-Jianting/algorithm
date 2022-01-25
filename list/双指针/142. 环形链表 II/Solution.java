/**
 * 判断链表是否有环: 通过快慢双指针, 若快慢双指针会相遇, 那么链表是有环的
 * 假设相遇时, 慢指针走了 k 步, 快指针走了 2k 步
 * 那么说明快指针多走的 k 步是绕环走了若干圈, 换言之, k 是环中节点数的整数倍
 * 因此, 如果记相遇点为 M, 从链表头走 k 步会到达 M, 从 M 点走 k 步会绕环若干圈后回到 M
 * 因此, 如果慢指针从头开始走, 快指针从 M 开始走, 那么它们相遇点即环的入口
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode meetNode = getNodeInLoop(head);
        if(meetNode == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = meetNode;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    private ListNode getNodeInLoop(ListNode head) { // 若链表存在环, 返回快慢双指针相遇点, 否则返回 null
        if(head == null || head.next == null || head.next.next == null) {
            return null;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while(slow != null && fast != null) {
            if(slow == fast) {
                return slow;
            }
            slow = slow.next;
            fast = fast.next;
            if(fast != null) {
                fast = fast.next;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // test 1
        System.out.println("test 1");
        ListNode list_1 = new ListNode(3);
        ListNode node_1 = ListNode.append(list_1, 2);
        ListNode.append(list_1, 0);
        ListNode node_3 = ListNode.append(list_1, -4);
        ListNode.print(list_1);
        node_3.next = node_1;
        System.out.println(new Solution().detectCycle(list_1).val);

        // test 2
        System.out.println("test 2");
        ListNode list_2 = new ListNode(1);
        ListNode node = ListNode.append(list_2, 2);
        ListNode.print(list_2);
        node.next = list_2;
        System.out.println(new Solution().detectCycle(list_2).val);

        // test 3
        System.out.println("test 3");
        ListNode list_3 = new ListNode(1);
        ListNode.print(list_3);
        System.out.println(new Solution().detectCycle(list_3) == null);
    }
}