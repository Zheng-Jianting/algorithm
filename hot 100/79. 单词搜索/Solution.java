class Solution {
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int m, n;
    char[][] board;
    String word;
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        this.board = board;
        this.word = word;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int k) {
        if (k == word.length()) {
            return true;
        } else if (i < 0 || i >= m || j < 0 || j >= n) {
            return false;
        } else if (visited[i][j] || board[i][j] != word.charAt(k)) {
            return false;
        }

        for (int idx = 0; idx < 4; idx++) {
            int nextI = i + dirs[idx][0];
            int nextJ = j + dirs[idx][1];
            visited[i][j] = true;
            boolean rst = dfs(nextI, nextJ, k + 1);
            visited[i][j] = false;
            if (rst) {
                return true;
            }
        }

        return false;
    }
}