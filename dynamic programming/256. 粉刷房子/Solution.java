class Solution {
    public int minCost(int[][] costs) {
        int n = costs.length;
        int[][] dp = new int[2][3];
        dp[0] = costs[0];
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < 3; j++) {
                dp[i % 2][j] = Math.min(dp[(i - 1) % 2][(j + 1) % 3], dp[(i - 1) % 2][(j + 2) % 3]) + costs[i][j];
            }
        }
        return Math.min(dp[(n - 1) % 2][0], Math.min(dp[(n - 1) % 2][1], dp[(n - 1) % 2][2]));
    }
}