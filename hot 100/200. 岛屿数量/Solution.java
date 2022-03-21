class Solution {
    static int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    char[][] grid;
    int m, n;
    int rst;

    public int numIslands(char[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        rst = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    rst++;
                    dfs(i, j);
                }
            }
        }

        return rst;
    }

    public void dfs(int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        } else if (grid[i][j] == '1') {
            grid[i][j] = '0';
            for (int[] dir : dirs) {
                dfs(i + dir[0], j + dir[1]);
            }
        }
    }
}