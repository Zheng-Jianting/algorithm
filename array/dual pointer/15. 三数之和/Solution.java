import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums, int target) { // 原题 target == 0 无 target 参数
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        int i, j, k;
        Arrays.sort(nums);
        for(i = 0; i < nums.length - 2; i++) {
            j = i + 1;
            k = nums.length - 1;
            while(j < k) {
                if(nums[j] + nums[k] < target - nums[i]) {
                    j++;
                }
                else if(nums[j] + nums[k] > target - nums[i]) {
                    k--;
                }
                else {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while(j < nums.length - 1 && nums[j] == nums[j+1]) { // 跳过相同的数
                        j++;
                    }
                    j++;
                }
            }
            while(i < nums.length - 1 && nums[i] == nums[i+1]) { // 跳过相同的数
                i++;
            }
        } 
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().threeSum(new int[] {-1, 0, 1, 2, -1, -4}, 0).toString());
        System.out.println(new Solution().threeSum(new int[] {0, 0, 0}, 0).toString());
    }
}