import java.util.Arrays;

public class Solution {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0)
            return null;
        int rootVal = preorder[0];
        int inorderRootValIdx = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                inorderRootValIdx = i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, 1 + inorderRootValIdx), Arrays.copyOfRange(inorder, 0, inorderRootValIdx));
        root.right = buildTree(Arrays.copyOfRange(preorder, 1 + inorderRootValIdx, preorder.length), Arrays.copyOfRange(inorder, inorderRootValIdx + 1, inorder.length));
        return root;
    }
}