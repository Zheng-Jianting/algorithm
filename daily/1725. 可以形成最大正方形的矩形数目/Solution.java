import java.util.HashMap;
import java.util.Map;

class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        int maxLength = Integer.MIN_VALUE;
        Map<Integer, Integer> lenToCount = new HashMap<>();
        for(int i = 0; i < rectangles.length; i++) {
            int length = Math.min(rectangles[i][0], rectangles[i][1]);
            lenToCount.put(length, lenToCount.getOrDefault(length, 0) + 1);
            maxLength = Math.max(maxLength, length);
        }
        return lenToCount.get(maxLength);
    }
}