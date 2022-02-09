class Solution {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode pruneTree(TreeNode root) { // 返回值为以 root 为根的树剪枝后的结果
        if(root == null) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if(root.val == 0 && root.left == null && root.right == null) {
            return null;
        }
        return root;
    }
}