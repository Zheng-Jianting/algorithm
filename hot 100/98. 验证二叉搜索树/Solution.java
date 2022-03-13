import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
    }

    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        long val = Long.MIN_VALUE;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if ((long) cur.val <= val) {
                return false;
            }
            val = (long) cur.val;
            cur = cur.right;
        }
        return true;
    }
}