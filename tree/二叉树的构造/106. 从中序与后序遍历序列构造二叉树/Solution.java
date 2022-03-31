public class Solution {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    // 从 inorder[iStart, iEnd] 以及对应的 postorder[pStart, pEnd] 构建二叉树
    private TreeNode helper(int[] inorder, int iStart, int iEnd, int[] postorder, int pStart, int pEnd) {
        if (iEnd - iStart + 1 <= 0)
            return null;
        int k = 0;
        for (int i = iStart; i <= iEnd; i++) {
            if (inorder[i] == postorder[pEnd]) {
                k = i;
                break;
            }
        }
        // 左子树节点数量: inorder[iStart, k)  k - iStart
        // 右子树节点数量: inorder[k + 1, iEnd]  iEnd - k
        TreeNode root = new TreeNode(inorder[k]);
        root.left = helper(inorder, iStart, k - 1, postorder, pStart, pStart + k - iStart - 1);
        root.right = helper(inorder, k + 1, iEnd, postorder, pStart + k - iStart, pEnd - 1);
        return root;
    }
}