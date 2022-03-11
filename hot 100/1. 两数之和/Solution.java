import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numToIdx = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numToIdx.containsKey(target - nums[i])) {
                return new int[] {i, numToIdx.get(target - nums[i])};
            }
            numToIdx.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }
}