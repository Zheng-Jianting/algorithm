public class Optimize {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    // 从 preorder[pStart, pEnd] 以及对应的 inorder[iStart, iEnd] 构建二叉树
    private TreeNode helper(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        if (pEnd - pStart + 1 <= 0)
            return null;
        int k = 0;
        for (int i = iStart; i <= iEnd; i++) {
            if (inorder[i] == preorder[pStart]) {
                k = i;
                break;
            }
        }
        TreeNode root = new TreeNode(preorder[pStart]);
        // 左子树节点个数: k - iStart ( inorder[iStart, k) )
        // 右子树节点个数: iEnd - k ( (inorder[k + 1, iEnd]) )
        root.left = helper(preorder, pStart + 1, pStart + k - iStart, inorder, iStart, k - 1);
        root.right = helper(preorder, pStart + k - iStart + 1, pEnd, inorder, k + 1, iEnd);
        return root;
    }
}