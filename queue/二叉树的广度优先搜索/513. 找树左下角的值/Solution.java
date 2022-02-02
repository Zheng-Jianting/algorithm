import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public int findBottomLeftValue(TreeNode root) {
        int leftValue = root.val;
        Queue<TreeNode> cur = new LinkedList<TreeNode>();
        Queue<TreeNode> next = new LinkedList<TreeNode>();
        cur.offer(root);
        while(!cur.isEmpty()) {
            TreeNode treeNode = cur.poll();
            if(treeNode.left != null) {
                next.offer(treeNode.left);
            }
            if(treeNode.right != null) {
                next.offer(treeNode.right);
            }
            if(cur.isEmpty()) {
                if(!next.isEmpty()) {
                    leftValue = next.peek().val;
                }
                cur = next;
                next = new LinkedList<TreeNode>();
            }
        }
        return leftValue;
    }
}