class Solution {
    int m, n;
    int[][] dp;
    boolean[][] visited;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        m = obstacleGrid.length;
        n = obstacleGrid[0].length;
        dp = new int[m][n];
        visited = new boolean[m][n];
        return dfs(obstacleGrid, 0, 0);
    }

    private int dfs(int[][] obstacleGrid, int i, int j) {
        if (i >= m || j >= n) {
            return 0;
        } else if (visited[i][j]) {
            return dp[i][j];
        }

        if (obstacleGrid[i][j] == 1) {
            dp[i][j] = 0;
        } else if (i == m - 1 && j == n - 1) {
            dp[i][j] = 1;
        } else {
            dp[i][j] = dfs(obstacleGrid, i + 1, j) + dfs(obstacleGrid, i, j + 1);
        }

        visited[i][j] = true;
        return dp[i][j];
    }
}