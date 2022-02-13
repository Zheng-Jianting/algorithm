class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int length = cost.length;
        int[] dp = new int[length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i = 2; i < length; i++) {
            dp[i] = Math.min(dp[i - 2], dp[i - 1]) + cost[i];
        }
        return Math.min(dp[length - 1], dp[length - 2]);
    }

    public int minCostClimbingStairsOptimize(int[] cost) {
        int length = cost.length;
        int[] dp = new int[2];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i = 2; i < length; i++) {
            dp[i % 2] = Math.min(dp[(i - 2) % 2], dp[(i - 1) % 2]) + cost[i];
        }
        return Math.min(dp[(length - 1) % 2], dp[(length - 2) % 2]);
    }
}