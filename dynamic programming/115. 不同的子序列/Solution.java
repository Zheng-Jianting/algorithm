class Solution {
    public int numDistinct(String s, String t) {
        if(s.length() < t.length()) {
            return 0;
        }
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[2][n + 1];
        for(int i = -1; i < m; i++) {
            for(int j = -1; j <= i && j < n; j++) {
                if(i == -1 || j == -1) {
                    dp[(i + 1) % 2][j + 1] = 1;
                }
                else {
                    dp[(i + 1) % 2][j + 1] = s.charAt(i) == t.charAt(j) ? dp[i % 2][j] + dp[i % 2][j + 1] : dp[i % 2][j + 1];
                }
            }
        }
        return dp[m % 2][n];
    }
}