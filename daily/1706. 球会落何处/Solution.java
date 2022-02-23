class Solution {
    static final int[][] dirs = new int[][] { {1, 1}, {1, -1} };
    private int m;
    private int n;
    private int[] result;

    public int[] findBall(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        result = new int[n];
        for(int j = 0; j < n; j++) {
            result[j] = dfs(grid, 0, j);
        }
        return result;
    }

    private int dfs(int[][] grid, int i, int j) {
        if(i == m - 1) {
            if(grid[i][j] == 1 && j < n - 1 && grid[i][j + 1] == 1) {
                return j + 1;
            }
            else if(grid[i][j] == -1 && j > 0 && grid[i][j - 1] == -1) {
                return j - 1;
            }
            else {
                return -1;
            }
        }
        else if(grid[i][j] == 1 && j < n - 1 && grid[i][j + 1] == 1) {
            return dfs(grid, i + dirs[0][0], j + dirs[0][1]);
        }
        else if(grid[i][j] == -1 && j > 0 && grid[i][j - 1] == -1) {
            return dfs(grid, i + dirs[1][0], j + dirs[1][1]);
        }
        else {
            return -1;
        }
    }
}