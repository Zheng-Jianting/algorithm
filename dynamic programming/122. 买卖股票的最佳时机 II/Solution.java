class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) {
            return 0;
        }
        int[] dp = new int[2];
        for (int i = 1; i < n; i++) {
            dp[i%2] = dp[(i-1)%2] + (prices[i] > prices[i-1] ? prices[i] - prices[i-1] : 0);
        }
        return dp[(n-1)%2];
    }
}