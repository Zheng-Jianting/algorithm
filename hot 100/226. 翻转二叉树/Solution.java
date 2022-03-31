class Solution {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
    }

    public TreeNode invertTree(TreeNode root) {
        return dfs(root);
    }

    private TreeNode dfs(TreeNode root) {
        if (root == null) {
            return root;
        } else {
            dfs(root.left);
            dfs(root.right);
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            return root;
        }
    }
}