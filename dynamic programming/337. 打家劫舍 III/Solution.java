import java.util.HashMap;
import java.util.Map;

class Solution {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    private Map<TreeNode, Integer> rootToIncome; // 以该节点为根开始盗窃能获得的最大收益

    public int rob(TreeNode root) {
        rootToIncome = new HashMap<>();
        return dfs(root);
    }

    private int dfs(TreeNode root) {
        if(root == null) {
            return 0;
        }
        else if(rootToIncome.containsKey(root)) {
            return rootToIncome.get(root);
        }
        else {
            int rob = root.val;
            if(root.left != null) {
                rob += dfs(root.left.left);
                rob += dfs(root.left.right);
            }
            if(root.right != null) {
                rob += dfs(root.right.left);
                rob += dfs(root.right.right);
            }

            int notRob = 0;
            if(root.left != null) {
                notRob += dfs(root.left);
            }
            if(root.right != null) {
                notRob += dfs(root.right);
            }

            rootToIncome.put(root, Math.max(rob, notRob));
            return Math.max(rob, notRob);
        }
    }
}