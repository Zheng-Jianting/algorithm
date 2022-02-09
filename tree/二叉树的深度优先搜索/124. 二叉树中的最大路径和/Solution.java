class Solution {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    private int result = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return result;
    }

    private int dfs(TreeNode root) { // 返回值为以 root 为根的子树路径最大值 (路径是单向的, 没有分叉)
        if(root == null) {
            return 0;
        }
        int left = Math.max(dfs(root.left), 0); // 如果子树路径最大值为负数, 置 0
        int right = Math.max(dfs(root.right), 0);
        result = Math.max(result, root.val + left + right); // result 取单向 / 分叉路径最大值
        return root.val + Math.max(left, right);
    }
}