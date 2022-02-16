class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) {
            return false;
        }

        int m = s1.length();
        int n = s2.length();
        boolean[][] dp = new boolean[2][n + 1];
        for(int j = -1; j < n; j++) { // f(-1, j)
            dp[0][j + 1] = j == -1 ? true : dp[0][j] && s2.charAt(j) == s3.charAt(j);
        }
        for(int i = 0; i < m; i++) {
            for(int j = -1; j < n; j++) {
                if(j == -1) { // f(i, -1)
                    dp[(i + 1) % 2][0] = dp[i % 2][0] && s1.charAt(i) == s3.charAt(i);
                }
                else {
                    dp[(i + 1) % 2][j + 1] = (s1.charAt(i) == s3.charAt(i + j + 1) && dp[i % 2][j + 1]) || (s2.charAt(j) == s3.charAt(i + j + 1) && dp[(i + 1) % 2][j]);
                }
            }
        }
        return dp[m % 2][n];
    }
}