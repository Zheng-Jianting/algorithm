class Solution {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int path) {
        if(root == null) {
            return 0;
        }
        path = path * 10 + root.val;
        if(root.left == null && root.right == null) {
            return path;
        }

        int left = dfs(root.left, path);
        int right = dfs(root.right, path);

        return left + right;
    }
}