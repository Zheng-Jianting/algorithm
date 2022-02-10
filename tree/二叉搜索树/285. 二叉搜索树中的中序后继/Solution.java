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

    // 时间复杂度 O(n), 空间复杂度 O(k), 适用于任何树, 没有利用到二叉搜索树的特点
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        boolean isFound = false;
        while(cur != null || !stack.isEmpty()) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if(isFound) {
                break;
            }
            else if(cur == p) {
                isFound = true;
            }
            cur = cur.right;
        }
        return cur;
    }

    // 节点唯一, p 中序遍历的下一个节点的值必然比 p 大, 如果当前节点比 p 大, 则当前节点可能是答案, 接着往左走看有没有更小的
    // 时间复杂度 O(k), 空间复杂度 O(1)
    public TreeNode inorderSuccessorOptimize(TreeNode root, TreeNode p) {
        TreeNode result = null;
        TreeNode cur = root;
        while(cur != null) {
            if(cur.val <= p.val) {
                cur = cur.right;
            }
            else {
                result = cur;
                cur = cur.left;
            }
        }
        return result;
    }
}