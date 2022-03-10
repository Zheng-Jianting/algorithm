import java.util.LinkedList;
import java.util.List;

class Solution {
    private List<Integer> rst;

    public List<Integer> preorder(Node root) {
        rst = new LinkedList<>();
        dfs(root);
        return rst;
    }

    private void dfs(Node root) {
        if (root != null) {
            rst.add(root.val);
            for (Node node : root.children) {
                dfs(node);
            }
        }
    }
}