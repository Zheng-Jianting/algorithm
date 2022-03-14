class Solution {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
    }

    int rst;

    public int diameterOfBinaryTree(TreeNode root) {
        rst = Integer.MIN_VALUE;
        dfs(root);
        return rst == Integer.MIN_VALUE ? 0 : rst;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = dfs(root.left);
        int rightDepth = dfs(root.right);
        rst = Math.max(rst, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}