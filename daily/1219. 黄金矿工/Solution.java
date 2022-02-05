class Solution {
    private static int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    private int[][] grid;
    private int m, n;
    private int result;

    public int getMaximumGold(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] > 0) {
                    dfs(i, j, 0);
                }
            }
        }
        return result;
    }

    private void dfs(int i, int j, int gold) {
        gold += grid[i][j];
        result = Math.max(result, gold);
        int temp = grid[i][j];
        grid[i][j] = 0;
        for(int k = 0; k < 4; k++) {
            int nexti = i + directions[k][0];
            int nextj = j + directions[k][1];
            if(nexti >= 0 && nexti < m && nextj >= 0 && nextj < n && grid[nexti][nextj] > 0) {
                dfs(nexti, nextj, gold);
            }
        }
        grid[i][j] = temp;
    }
}