import java.util.LinkedList;
import java.util.Queue;

class CBTInserter {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    private TreeNode root;
    private Queue<TreeNode> queue;

    public CBTInserter(TreeNode root) {
        this.root = root;
        queue = new LinkedList<TreeNode>();
        if(root != null) {
            queue.offer(root);
        }
        while(queue.peek().left != null && queue.peek().right != null) {
            TreeNode node = queue.poll();
            queue.offer(node.left);
            queue.offer(node.right);
        }
    }
    
    public int insert(int val) {
        TreeNode child = new TreeNode();
        child.val = val;
        TreeNode parent = queue.peek();
        if(parent.left == null) {
            parent.left = child;
        }
        else if(parent.right == null) {
            parent.right = child;
            queue.poll();
            queue.offer(parent.left);
            queue.offer(parent.right);
        }
        return parent.val;
    }
    
    public TreeNode get_root() {
        return this.root;
    }
}