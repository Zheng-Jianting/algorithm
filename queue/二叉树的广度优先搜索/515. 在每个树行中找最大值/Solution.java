import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> cur = new LinkedList<TreeNode>();
        Queue<TreeNode> next = new LinkedList<TreeNode>();
        if(root != null) {
            cur.offer(root);
        }
        List<Integer> result = new LinkedList<Integer>();
        int maxValue = Integer.MIN_VALUE;
        while(!cur.isEmpty()) {
            TreeNode node = cur.poll();
            maxValue = Math.max(maxValue, node.val);
            if(node.left != null) {
                next.offer(node.left);
            }
            if(node.right != null) {
                next.offer(node.right);
            }

            if(cur.isEmpty()) {
                result.add(maxValue);
                maxValue = Integer.MIN_VALUE;
                cur = next;
                next = new LinkedList<TreeNode>();
            }
        }
        return result;
    }
}