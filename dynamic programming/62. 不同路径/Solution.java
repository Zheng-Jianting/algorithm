class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[2][n + 1];
        for(int i = -1; i < m; i++) {
            for(int j = -1; j < n; j++) {
                if(i == -1 || j == -1) {
                    dp[(i + 1) % 2][j + 1] = 0;
                }
                else if(i == 0 && j == 0) {
                    dp[(i + 1) % 2][j + 1] = 1;
                }
                else {
                    dp[(i + 1) % 2][j + 1] = dp[i % 2][j + 1] + dp[(i + 1) % 2][j];
                }
            }
        }
        return dp[m % 2][n];
    }
}