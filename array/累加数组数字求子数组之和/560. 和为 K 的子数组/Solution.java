import java.util.HashMap;

public class Solution {
    /**
     * 记 Sn 为 nums 区间 [0, n] 的和 若存在 m < n 且 Sm == Sn - k 那么 [m+1, n] 的区间和为 k
     * 因此在遍历 nums 时累加求和 并且维护一个哈希表 key 为目前得到过的和 S value 为 S 目前出现过的次数
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        int sum = 0;
        HashMap<Integer, Integer> sumToCount = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            result += sumToCount.getOrDefault(sum - k, 0); // Sm == sum - k
            result += (sum == k) ? 1 : 0; // Sn == k
            sumToCount.put(sum, sumToCount.getOrDefault(sum, 0) + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().subarraySum(new int[] {1, 1, 1}, 2));
        System.out.println(new Solution().subarraySum(new int[] {1, 2, 3}, 3));
    }
}