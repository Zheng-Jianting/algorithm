import java.util.HashMap;
import java.util.Map;

class Solution {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    private int pathSum;
    private int result;

    public int pathSum(TreeNode root, int targetSum) {
        this.pathSum = 0;
        this.result = 0;
        Map<Integer, Integer> map = new HashMap<>(); // 仅保存当前搜索路径上的和出现的次数
        map.put(0, 1); // 细节, 表明当前路径和恰好等于 targetSum
        dfs(root, targetSum, map, pathSum);
        return this.result;
    }

    private void dfs(TreeNode root, int targetSum, Map<Integer, Integer> map, int pathSum) {
        if(root == null) {
            return;
        }
        pathSum += root.val;
        this.result += map.getOrDefault(pathSum - targetSum, 0);
        map.put(pathSum, map.getOrDefault(pathSum, 0) + 1);

        dfs(root.left, targetSum, map, pathSum);
        dfs(root.right, targetSum, map, pathSum);

        map.put(pathSum, map.get(pathSum) - 1); // 接下来返回父节点, 表明下次搜索的是另外一条路径, 因此将当前路径和减一
    }
}