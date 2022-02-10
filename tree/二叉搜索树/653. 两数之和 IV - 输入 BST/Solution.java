import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean findTarget(TreeNode root, int k) { // 最直观思路: 中序遍历 + 哈希表, 时间复杂度 O(n), 空间复杂度 O(n)
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        Set<Integer> set = new HashSet<>();
        while(cur != null || !stack.isEmpty()) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if(set.contains(k - cur.val)) {
                return true;
            }
            set.add(cur.val);
            cur = cur.right;
        }
        return false;
    }

    // BST 迭代器 + 双指针, 空间复杂度优化为 O(k)
    Deque<TreeNode> frontStack; // 升序遍历, 即正常的中序遍历
    TreeNode front;

    boolean frontHasNext() {
        return front != null || !frontStack.isEmpty();
    }

    private TreeNode frontNext() {
        while(front != null) {
            frontStack.push(front);
            front = front.left;
        }
        front = frontStack.pop();
        TreeNode next = front;
        front = front.right;
        return next;
    }

    Deque<TreeNode> backStack; // 降序遍历, 即反向的中序遍历
    TreeNode back;

    boolean backHasNext() {
        return back != null || !backStack.isEmpty();
    }

    private TreeNode backNext() {
        while(back != null) {
            backStack.push(back);
            back = back.right;
        }
        back = backStack.pop();
        TreeNode next = back;
        back = back.left;
        return next;
    }

    public boolean findTargetOptimize(TreeNode root, int k) {
        frontStack = new ArrayDeque<>();
        front = root;
        backStack = new ArrayDeque<>();
        back = root;

        TreeNode p1 = frontNext(); 
        TreeNode p2 = backNext();
        while(p1.val < p2.val) {
            if(p1.val + p2.val == k) {
                return true;
            }
            
            if(p1.val + p2.val < k) {
                p1 = frontNext();
            }
            else {
                p2 = backNext();
            }
        }

        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(new Solution().findTargetOptimize(root, 3));
    }
}