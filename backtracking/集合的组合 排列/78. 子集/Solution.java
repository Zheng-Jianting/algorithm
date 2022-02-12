import java.util.LinkedList;
import java.util.List;

class Solution {
    private List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        result = new LinkedList<>();
        dfs(nums, 0, new LinkedList<>());
        return result;
    }

    private void dfs(int[] nums, int i, LinkedList<Integer> subSet) {
        if(i == nums.length) {
            result.add(new LinkedList<>(subSet));
        }
        else if(i < nums.length) {
            dfs(nums, i + 1, subSet);

            subSet.add(nums[i]);
            dfs(nums, i + 1, subSet);
            subSet.removeLast();
        }
    }
}