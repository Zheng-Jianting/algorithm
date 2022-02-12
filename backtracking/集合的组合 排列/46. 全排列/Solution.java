import java.util.LinkedList;
import java.util.List;

class Solution {
    private List<List<Integer>> result;

    public List<List<Integer>> permute(int[] nums) {
        result = new LinkedList<>();
        dfs(nums, 0);
        return result;
    }

    private void dfs(int[] nums, int i) {
        if(i == nums.length) {
            List<Integer> permutation = new LinkedList<>();
            for(int num : nums) {
                permutation.add(num);
            }
            result.add(permutation);
        }
        else if(i < nums.length) {
            for(int j = i; j < nums.length; j++) {
                swap(nums, i, j);
                dfs(nums, i + 1);
                swap(nums, i, j);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}