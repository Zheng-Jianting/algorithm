class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[2][n + 1];
        for(int i = -1; i < m; i++) {
            for(int j = -1; j < n; j++) {
                if(i == -1 || j == -1) {
                    dp[(i + 1) % 2][j + 1] = 0;
                }
                else {
                    dp[(i + 1) % 2][j + 1] = text1.charAt(i) == text2.charAt(j) ? Math.max(dp[i % 2][j] + 1, dp[i % 2][j + 1]) : Math.max(dp[i % 2][j + 1], dp[(i + 1) % 2][j]);
                }
            }
        }
        return dp[m % 2][n];
    }
}