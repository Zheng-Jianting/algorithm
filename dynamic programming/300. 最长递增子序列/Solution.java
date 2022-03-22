class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int rst = 1;
        for (int i = 0; i < nums.length; i++) {
            int k = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i])
                    k = Math.max(k, dp[j]);
            }
            dp[i] = k + 1;
            rst = Math.max(rst, dp[i]);
        }
        return rst;
    }
}