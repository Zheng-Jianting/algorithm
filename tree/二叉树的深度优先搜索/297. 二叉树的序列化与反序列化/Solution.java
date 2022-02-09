public class Solution {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) {
            return "#"; // 即使节点为空也要记录, 否则序列化的结果可能对应多种树的结构
        }
        String left = serialize(root.left);
        String right = serialize(root.right);
        return String.valueOf(root.val) + "," + left + "," + right;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) { // 以前序遍历序列化的好处就是第一个节点就是根节点
        String[] values = data.split(",");
        int[] i = { 0 };
        return dfs(values, i);
    }

    private TreeNode dfs(String[] values, int[] i) { // 返回值为以 values[i[0]] 为根的子树
        if(values[i[0]].equals("#")) {
            i[0]++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(values[i[0]]));
        i[0]++;
        root.left = dfs(values, i);
        root.right = dfs(values, i);
        return root;
    }
}