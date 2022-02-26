class Solution {
    public int maximumDifference(int[] nums) {
        int[] dp = new int[2];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            if (i == 0) 
                dp[i % 2] = Integer.MIN_VALUE;
            else
                dp[i % 2] = Math.max(dp[(i-1) % 2], nums[i] - min);
            min = Math.min(min, nums[i]);
        }
        return dp[(nums.length - 1) % 2] > 0 ? dp[(nums.length - 1) % 2] : -1;
    }
}