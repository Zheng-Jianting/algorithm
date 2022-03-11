class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        for (int j = -1; j < p.length(); j++) {
            if (j == -1) {
                dp[0][j+1] = true;
            } else {
                dp[0][j+1] = p.charAt(j) == '*' ? dp[0][j-1] : false;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '*') {
                    dp[i+1][j+1] = s.charAt(i) == p.charAt(j-1) || p.charAt(j-1) == '.' ? dp[i][j+1] || dp[i+1][j-1] : dp[i+1][j-1];
                } else {
                    dp[i+1][j+1] = dp[i][j] && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}