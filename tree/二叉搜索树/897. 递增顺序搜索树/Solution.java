import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode increasingBST(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        TreeNode prev = null;
        TreeNode first = null;
        while(cur != null || !stack.isEmpty()) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if(prev == null) {
                first = cur;
            }
            else {
                prev.right = cur;
                cur.left = null;
            }
            prev = cur;
            cur = cur.right;
        }
        return first;
    }
}