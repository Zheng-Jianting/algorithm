import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
    }

    public boolean isSymmetric(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        List<TreeNode> list = new ArrayList<>();
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur);
            cur = cur.right;
        }

        int i = 0, j = list.size() - 1;
        while (i < j) {
            TreeNode n1 = list.get(i), n2 = list.get(j);
            int leftChild1 = n1.left == null ? Integer.MIN_VALUE : n1.left.val;
            int rightChild1 = n1.right == null ? Integer.MIN_VALUE : n1.right.val;
            int leftChild2 = n2.left == null ? Integer.MIN_VALUE : n2.left.val;
            int rightChild2 = n2.right == null ? Integer.MIN_VALUE : n2.right.val;
            if (n1.val != n2.val || leftChild1 != rightChild2 || rightChild1 != leftChild2) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}