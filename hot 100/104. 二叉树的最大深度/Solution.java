class Solution {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
    }

    int rst = 0;

    public int maxDepth(TreeNode root) {
        dfs(root, 1);
        return rst;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        rst = Math.max(rst, depth);
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
}