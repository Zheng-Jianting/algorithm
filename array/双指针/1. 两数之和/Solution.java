import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public int[] twoSum(int[] nums, int target) { // nums 并非有序的 双指针不适用
        int i = 0, j = nums.length - 1;
        Arrays.sort(nums);
        while(i < j && (nums[i] + nums[j]) != target) {
            if((nums[i] + nums[j]) < target) {
                i++;
            }
            else {
                j--;
            }
        }
        return new int[] {i, j};
    }

    public int[] twoSumHashMap(int[] nums, int target) {
        int i = -1, j = -1;

        if((target & 1) == 0) { // target 为偶数，且 nums[i] == nums[j] == target/2
            int halfTarget = target / 2;
            for(int k = 0; k < nums.length; k++) {
                if(nums[k] == halfTarget) {
                    if(i == -1) {
                        i = k;
                    }
                    else {
                        j = k;
                    }
                }
            }

            if(i != -1 && j != -1) {
                return new int[] {i, j};
            }
        }

        HashMap<Integer, Integer> numToIndex = new HashMap<>();
        for(int k = 0; k < nums.length; k++) {
            if(!((target & 1) == 0 && nums[k] == target / 2)) { // 答案非 nums[i] == nums[j] == target/2 这种情况
                numToIndex.put(nums[k], k);
            }
        }

        for(int k = 0; k < nums.length; k++) {
            if(numToIndex.get(target - nums[k]) != null) {
                i = k;
                j = numToIndex.get(target - nums[k]);
                break;
            }
        }

        return new int[] {i, j};
    }

    /**
     * twoSumHashMap把nums[i]==nums[j]==target/2这种情况处理得太麻烦了
     * 如果在遍历nums时始终保持HashMap中的key两两之和不等于target，可以简便地处理上面那种特殊情况
     */
    public int[] twoSumHashMapOptimize(int[] nums, int target) {
        int i = -1, j = -1;
        HashMap<Integer, Integer> numToIndex = new HashMap<>();
        for(int k = 0; k < nums.length; k++) {
            if(numToIndex.containsKey(target - nums[k])) {
                i = numToIndex.get(target - nums[k]);
                j = k;
                break;
            }
            numToIndex.put(nums[k], k);
        }
        return new int[] {i, j};
    }

    public static void main(String[] args) {
        int[] result = new Solution().twoSumHashMapOptimize(new int[] {3, 2, 4}, 6);
        System.out.println(result[0] + " " + result[1]);
    }
}