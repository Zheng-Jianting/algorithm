import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        Map<Integer, Integer> rowToMax = new HashMap<>();
        Map<Integer, Integer> colToMax = new HashMap<>();
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(!rowToMax.containsKey(i) || matrix[i][j] < rowToMax.get(i)) {
                    rowToMax.put(i, matrix[i][j]);
                }
                if(!colToMax.containsKey(j) || matrix[i][j] > colToMax.get(j)) {
                    colToMax.put(j, matrix[i][j]);
                }
            }
        }

        List<Integer> result = new LinkedList<>();
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == rowToMax.get(i) && matrix[i][j] == colToMax.get(j)) {
                    result.add(matrix[i][j]);
                }
            }
        }

        return result;
    }
}