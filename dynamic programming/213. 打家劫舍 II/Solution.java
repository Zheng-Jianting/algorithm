class Solution {
    public int rob(int[] nums) {
        if(nums.length <= 2) {
            return nums.length == 1 ? nums[0] : Math.max(nums[0], nums[1]);
        }
        return Math.max(helper(nums, 0, nums.length - 2), helper(nums, 1, nums.length - 1));
    }

    private int helper(int[] nums, int i, int j) {
        if((j - i + 1) <= 2) {
            return (j - i + 1) == 1 ? nums[i] : Math.max(nums[i], nums[j]);
        }
        int[] dp = new int[2];
        dp[i % 2] = nums[i];
        dp[(i + 1) % 2] = Math.max(nums[i], nums[i + 1]);
        for(int k = i + 2; k <= j; k++) {
            dp[k % 2] = Math.max(dp[(k - 2) % 2] + nums[k], dp[(k - 1) % 2]);
        }
        return dp[j % 2];
    }
}