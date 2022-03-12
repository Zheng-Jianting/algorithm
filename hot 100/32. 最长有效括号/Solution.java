class Solution {
    public int longestValidParentheses(String s) {
        int rst = Integer.MIN_VALUE;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '(') 
                continue;
            if (s.charAt(i - 1) == '(') {
                dp[i] = (i - 2 >= 0 ? dp[i - 2] : 0) + 2;
            } else if (i - dp[i-1] -1 >= 0 && s.charAt(i - dp[i-1] - 1) == '(') {
                dp[i] = dp[i-1] + 2 + (i - dp[i-1] - 2 >= 0 ? dp[i - dp[i-1] - 2] : 0);
            }
            rst = Math.max(rst, dp[i]);
        }
        return rst == Integer.MIN_VALUE ? 0 : rst;
    }
}