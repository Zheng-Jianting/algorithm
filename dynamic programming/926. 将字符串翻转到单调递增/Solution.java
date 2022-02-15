class Solution {
    public int minFlipsMonoIncr(String s) {
        int[][] dp = new int[2][2];
        dp[0][0] = 0;
        dp[0][1] = 1;
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i - 1) == '0' && s.charAt(i) == '0') {
                dp[i % 2][0] = dp[(i - 1) % 2][0];
                dp[i % 2][1] = Math.min(dp[(i - 1) % 2][0], dp[(i - 1) % 2][1]) + 1;
            }
            else if(s.charAt(i - 1) == '0' && s.charAt(i) == '1') {
                dp[i % 2][0] = Math.min(dp[(i - 1) % 2][0], dp[(i - 1) % 2][1]);
                dp[i % 2][1] = dp[(i - 1) % 2][0] + 1;
            }
            else if(s.charAt(i - 1) == '1' && s.charAt(i) == '0') {
                dp[i % 2][0] = dp[(i - 1) % 2][1];
                dp[i % 2][1] = Math.min(dp[(i - 1) % 2][0], dp[(i - 1) % 2][1]) + 1;
            }
            else if(s.charAt(i - 1) == '1' && s.charAt(i) == '1') {
                dp[i % 2][0] = Math.min(dp[(i - 1) % 2][0], dp[(i - 1) % 2][1]);
                dp[i % 2][1] = dp[(i - 1) % 2][1] + 1;
            }
        }
        return Math.min(dp[(s.length() - 1) % 2][0], dp[(s.length() - 1) % 2][1]);
    }
}