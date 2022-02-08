import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        Set<Long> lampSet = new HashSet<>(); // lamps 可以重复, 因此用 HashSet 存储 
        Map<Integer, Integer> row = new HashMap<>(); // 表示第 x 行被多少盏灯照亮
        Map<Integer, Integer> column = new HashMap<>(); // 表示第 y 列被多少盏灯照亮
        Map<Integer, Integer> diagonal = new HashMap<>(); // 表示 x - y 标识的正对角线被多少盏灯照亮
        Map<Integer, Integer> antiDiagonal = new HashMap<>(); // 表示 x + y 标识的反对角线被多少盏灯照亮
        for(int i = 0; i < lamps.length; i++) {
            if(!lampSet.add(hash(lamps[i][0], lamps[i][1]))) {
                continue;
            }
            row.put(lamps[i][0], row.getOrDefault(lamps[i][0], 0) + 1);
            column.put(lamps[i][1], column.getOrDefault(lamps[i][1], 0) + 1);
            diagonal.put(lamps[i][0] - lamps[i][1], diagonal.getOrDefault(lamps[i][0] - lamps[i][1], 0) + 1);
            antiDiagonal.put(lamps[i][0] + lamps[i][1], antiDiagonal.getOrDefault(lamps[i][0] + lamps[i][1], 0) + 1);
        }

        int[] result = new int[queries.length];
        for(int i = 0; i < queries.length; i++) {
            if(!row.containsKey(queries[i][0]) && !column.containsKey(queries[i][1]) // 被查询的网格所在行、列、正反对角线都没被照亮时, 值才为 0
                 && !diagonal.containsKey(queries[i][0] - queries[i][1]) 
                 && !antiDiagonal.containsKey(queries[i][0] + queries[i][1])) {
                result[i] = 0;
            }
            else {
                result[i] = 1;
            }

            for(int x = queries[i][0] - 1; x <= queries[i][0] + 1; x++) {
                for(int y = queries[i][1] - 1; y <= queries[i][1] + 1; y++) {
                    if(x < 0 || x >= n || y < 0 || y >= n) {
                        continue;
                    }
                    if(lampSet.contains(hash(x, y))) { // 该网格是栈灯则灭掉, 照亮其所在行、列、正反对角线的灯数量减一
                        lampSet.remove(hash(x, y));

                        row.put(x, row.get(x) - 1);
                        if(row.get(x) == 0) {
                            row.remove(x);
                        }
                        column.put(y, column.get(y) - 1);
                        if(column.get(y) == 0) {
                            column.remove(y);
                        }
                        diagonal.put(x - y, diagonal.get(x - y) - 1);
                        if(diagonal.get(x - y) == 0) {
                            diagonal.remove(x - y);
                        }
                        antiDiagonal.put(x + y, antiDiagonal.get(x + y) - 1);
                        if(antiDiagonal.get(x + y) == 0) {
                            antiDiagonal.remove(x + y);
                        }
                    }
                }
            }
        }

        return result;
    }

    private long hash(int a, int b) {
        return ((long) a << 32) + (long) b; // 优先级: 强制类型转换 > + - > 移位, 注意加括号
    }

    public static void main(String[] args) {
        System.out.println(new Solution().gridIllumination(5, 
            new int[][] { { 0, 0 }, { 0, 4 } }, 
            new int[][] { { 0, 4 }, { 0, 1 }, { 1, 4 } }));
    }
}