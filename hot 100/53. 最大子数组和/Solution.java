class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0, minPrefix = 0, rst = Integer.MIN_VALUE;
        for (int num : nums) {
            sum += num;
            rst = Math.max(rst, sum - minPrefix);
            minPrefix = Math.min(minPrefix, sum);
        }
        return rst;
    }
}