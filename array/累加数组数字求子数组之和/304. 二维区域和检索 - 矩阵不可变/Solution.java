public class Solution {
    public class NumMatrix {
        private int[][] sum; // sum[i][j] 表示 sum[1][1] ~ sum[i][j] 的和, 下标以 1 开始记

        public NumMatrix(int[][] matrix) {
            sum = new int[matrix.length + 1][matrix[0].length + 1]; // 套圈 0
            for(int i = 1; i < sum.length; i++) {
                for(int j = 1; j < sum[0].length; j++) {
                    sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + matrix[i-1][j-1];
                }
            }
        }
        
        public int sumRegion(int row1, int col1, int row2, int col2) {
            row1++; col1++; row2++; col2++;
            return sum[row2][col2] - sum[row1-1][col2] - sum[row2][col1-1] + sum[row1-1][col1-1];
        }
    }
}