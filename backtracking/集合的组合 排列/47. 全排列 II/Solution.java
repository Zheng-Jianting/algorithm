import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class Solution {
    private List<List<Integer>> result;

    public List<List<Integer>> permuteUnique(int[] nums) {
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
            Set<Integer> set = new HashSet<>();
            for(int j = i; j < nums.length; j++) {
                if(set.contains(nums[j])) { // 如果集合有重复元素, 交换重复元素得到的是同一个全排列
                    continue;
                }
                set.add(nums[j]);

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