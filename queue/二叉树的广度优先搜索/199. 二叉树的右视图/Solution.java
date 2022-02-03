import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;    
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new LinkedList<Integer>();
        Queue<TreeNode> cur = new ArrayDeque<TreeNode>();
        Queue<TreeNode> next = new ArrayDeque<TreeNode>();
        if(root != null) {
            cur.offer(root);
        }
        while(!cur.isEmpty()) {
            TreeNode treeNode = cur.poll();
            if(treeNode.left != null) {
                next.offer(treeNode.left);
            }
            if(treeNode.right != null) {
                next.offer(treeNode.right);
            }
            if(cur.isEmpty()) {
                result.add(treeNode.val);
                cur = next;
                next = new ArrayDeque<TreeNode>();
            }
        }
        return result;
    }
}