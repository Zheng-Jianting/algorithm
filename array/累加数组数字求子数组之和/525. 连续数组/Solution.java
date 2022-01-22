import java.util.HashMap;

public class Solution {
    /**
     * 若将 -1 转换成 0 问题就变成求和为 0 的最长子数组
     * 子数组的和可以用双指针, 但是 nums 有负数, 因此双指针不适用
     * 记 Sn 为区间 [0, n] 的和, 若存在 m < n 且 Sm == Sn, 那么区间 [m+1, n] 的和为 0
     * 为了使区间长度 n-m 最大, Sm 的下标值 m 需要最小, 因此只存储和为 Sm 第一次出现的下标 m 即可
     * @param nums
     * @return
     */
    public int findMaxLength(int[] nums) {
        int maxLength = Integer.MIN_VALUE;
        int sum = 0;
        HashMap<Integer, Integer> sumToIndex = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            sum += (nums[i] == 0) ? -1 : nums[i]; // 把 0 转换成 -1
            if(sumToIndex.containsKey(sum)) { // 存在 Sm == Sn
                maxLength = Math.max(maxLength, i - sumToIndex.get(sum));
            }
            else { // 只有当 sum 没出现过才 put 进哈希表, 换言之, 哈希表存的是 sum 第一次出现的下标 i
                sumToIndex.put(sum, i);
            }
            maxLength = (sum == 0) ? i + 1 : maxLength; // 若 sum == 0 那么 [0, i] 无疑是目前最长的
        }
        return (maxLength == Integer.MIN_VALUE) ? 0 : maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findMaxLength(new int[] {0, 1}));
        System.out.println(new Solution().findMaxLength(new int[] {0, 1, 0}));
    }
}