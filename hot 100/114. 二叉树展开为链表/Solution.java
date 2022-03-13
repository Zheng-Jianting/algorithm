import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
    }

    public void flatten(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        Deque<TreeNode> containerStack = new ArrayDeque<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                containerStack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }

        if (!containerStack.isEmpty()) {
            cur = containerStack.pop();
        }
        while (!containerStack.isEmpty()) {
            TreeNode front = containerStack.pop();
            front.left = null;
            front.right = cur;
            cur = front;
        }
    }
}