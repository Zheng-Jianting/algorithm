import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    static int[][] dirs = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
    int m, n;
    boolean[][] visited;

    // DFS
    public int numEnclaves(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            if(grid[i][0] == 1) {
                dfs(grid, i, 0);
            }
            if(grid[i][n - 1] == 1) {
                dfs(grid, i, n - 1);
            }
        }
        for(int j = 1; j < n - 1; j++) {
            if(grid[0][j] == 1) {
                dfs(grid, 0, j);
            }
            if(grid[m - 1][j] == 1) {
                dfs(grid, m - 1, j);
            }
        }

        int result = 0;
        for(int i = 1; i < m - 1; i++) {
            for(int j = 1; j < n - 1; j++) {
                if(grid[i][j] == 1 && visited[i][j] == false) {
                    result++;
                }
            }
        }
        return result;
    }

    private void dfs(int[][] grid, int i, int j) {
        if(i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }
        else if(visited[i][j] || grid[i][j] == 0) {
            return;
        }
        else {
            visited[i][j] = true;
            for(int k = 0; k < 4; k++) {
                dfs(grid, i + dirs[k][0], j + dirs[k][1]);
            }
        }
    }

    // BFS
    public int numEnclavesBFS(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        Queue<int[]> queue = new ArrayDeque<>();
        for(int i = 0; i < m; i++) {
            if(grid[i][0] == 1) {
                queue.offer(new int[] { i, 0 });
            }
            if(grid[i][n - 1] == 1) {
                queue.offer(new int[] { i, n - 1 });
            }
        }
        for(int j = 1; j < n - 1; j++) {
            if(grid[0][j] == 1) {
                queue.offer(new int[] { 0, j });
            }
            if(grid[m - 1][j] == 1) {
                queue.offer(new int[] { m - 1, j });
            }
        }

        while(!queue.isEmpty()) {
            int[] loc = queue.poll();
            int i = loc[0];
            int j = loc[1];
            visited[i][j] = true;
            for(int k = 0; k < 4; k++) {
                int nextI = i + dirs[k][0];
                int nextJ = j + dirs[k][1];
                if(nextI >= 0 && nextI < m && nextJ >= 0 && nextJ < n && grid[nextI][nextJ] == 1 && !visited[nextI][nextJ]) {
                    visited[nextI][nextJ] = true;
                    queue.offer(new int[] { nextI, nextJ });
                }
            }
        }

        int result = 0;
        for(int i = 1; i < m - 1; i++) {
            for(int j = 1; j < n - 1; j++) {
                if(!visited[i][j] && grid[i][j] == 1) {
                    result++;
                }
            }
        }
        return result;
    }
}