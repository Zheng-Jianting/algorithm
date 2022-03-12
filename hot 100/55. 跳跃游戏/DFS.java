public class DFS {
    public static int[] nums;
    public static int[] dp;

    public boolean canJump(int[] nums) {
        this.nums = nums;
        dp = new int[nums.length];
        return dfs(nums, 0);
    }

    public static boolean dfs(int[] nums, int i) {
        if (dp[i] != 0) {
            return dp[i] == 1;
        }

        if (i == nums.length - 1) {
            dp[i] = 1;
            return true;
        } else if (i < nums.length) {
            for (int k = 0; k < nums[i]; k++) {
                if (dfs(nums, i + k + 1)) {
                    dp[i] = 1;
                    return true;
                }
            }
            dp[i] = -1;
        }

        return false;
    }
}