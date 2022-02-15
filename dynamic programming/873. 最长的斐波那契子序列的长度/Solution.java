import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }
        
        int[][] dp = new int[n][n];
        int result = 2;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                int k = map.getOrDefault(arr[i] - arr[j], -1);
                dp[i][j] = (k >= 0 && j > k) ? dp[j][k] + 1 : 2;
                result = Math.max(result, dp[i][j]);
            }
        }

        return result > 2 ? result : 0;
    }
}