public class Solution {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    // 实际上前序和后序并不能确定一颗二叉树, eg:
    //   1     1
    //  2       2
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return helper(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
    }

    // 重点是判断左子树的节点数量
    // preorder[preStart + 1] 为左子树的根节点, 找到其在 postorder 中的位置即可
    private TreeNode helper(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd) {
        if (preEnd - preStart + 1 <= 0)
            return null;
        if (preStart == preEnd)
            return new TreeNode(preorder[preStart]);
        int k = 0;
        for (int i = postStart; i <= postEnd; i++) {
            if (postorder[i] == preorder[preStart + 1]) {
                k = i;
                break;
            }
        }
        // 左子树节点数量: postorder[postStart, k]  k - postStart + 1
        // 右子树节点数量: postorder[k + 1, postEnd)  postEnd - k - 1
        TreeNode root = new TreeNode(preorder[preStart]);
        root.left = helper(preorder, preStart + 1, preStart + 1 + k - postStart, postorder, postStart, k);
        root.right = helper(preorder, preStart + k - postStart + 2, preEnd, postorder, k + 1, postEnd - 1);
        return root;
    }
}