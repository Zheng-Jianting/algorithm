class Solution {
    static int[][] dirs = new int[][] { {-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1} };

    public double knightProbability(int n, int k, int row, int column) {
        double[][][] probaility = new double[n][n][k + 1];
        return dfs(n, row, column, k, probaility);
    }

    private double dfs(int n, int i, int j, int k, double[][][] probaility) {
        if(i < 0 || i >= n || j < 0 || j >= n) {
            return 0;
        }
        else if(k == 0) {
            return 1;
        }
        else if(probaility[i][j][k] == 0) {
            double result = 0;
            for(int r = 0; r < dirs.length; r++) {
                result += dfs(n, i + dirs[r][0], j + dirs[r][1], k - 1, probaility) / 8;
            }
            probaility[i][j][k] = result;
        }

        return probaility[i][j][k];
    }
}