class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] mins = new int[n];
        mins[0] = Integer.MAX_VALUE;
        for(int i = 1; i < n; i++) {
            mins[i] = Math.min(mins[i - 1], prices[i - 1]);
        }

        int[] dp = new int[2];
        dp[0] = 0;
        for(int i = 1; i < n; i++) {
            dp[i % 2] = Math.max(dp[(i - 1) % 2], prices[i] - mins[i]);
        }

        return dp[(n - 1) % 2];
    }

    public int maxProfitOptimize(int[] prices) {
        int n = prices.length;
        int[] dp = new int[2];
        dp[0] = 0;
        int minPrice = prices[0];
        for(int i = 1; i < n; i++) {
            dp[i % 2] = Math.max(dp[(i - 1) % 2], prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return dp[(n - 1) % 2];
    }
}