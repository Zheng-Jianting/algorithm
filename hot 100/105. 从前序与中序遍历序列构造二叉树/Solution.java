import java.util.Arrays;

class Solution {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(preorder, inorder);
    }

    private TreeNode dfs(int[] preorder, int[] inorder) {
        if (preorder.length == 0 && inorder.length == 0) {
            return null;
        }

        int k = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                k = i;
                break;
            }
        }

        TreeNode root = new TreeNode(preorder[0]);
        root.left = dfs(Arrays.copyOfRange(preorder, 1, 1 + k), Arrays.copyOfRange(inorder, 0, k));
        root.right = dfs(Arrays.copyOfRange(preorder, 1 + k, preorder.length), Arrays.copyOfRange(inorder, k + 1, inorder.length));
        return root;
    }
}