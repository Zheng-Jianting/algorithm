import java.util.Arrays;
import java.util.List;

public class Solution {
    // 时间复杂度 O(n) 使用哈希表避免排序
    public int findMinDifference(List<String> timePoints) {
        if(timePoints.size() > 24 * 60) { // 时间有重复的
            return 0;
        }

        boolean[] isExist = new boolean[24 * 60]; // 模拟哈希表
        for(String time : timePoints) {
            String[] splitedTime = time.split(":");
            int hour = Integer.parseInt(splitedTime[0]);
            int minutes = Integer.parseInt(splitedTime[1]);
            if(isExist[hour * 60 + minutes]) { // 时间有重复的
                return 0;
            }
            isExist[hour * 60 + minutes] = true;
        }

        int prev = -1, minDifference = Integer.MAX_VALUE;
        int firstValue = 0, lastValue = 0; // ["05:31", "22:08", "00:35"] 避免最小间隔是跨天的
        for(int i = 0; i < isExist.length; i++) {
            if(isExist[i]) {
                if(prev == -1) {
                    firstValue = i;
                    prev = i;
                }
                else {
                    lastValue = i;
                    minDifference = Math.min(minDifference, i - prev);
                    prev = i;
                }
            }
        }

        return Math.min(minDifference, firstValue + 24 * 60 - lastValue);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findMinDifference(Arrays.asList("23:59", "00:00")));
        System.out.println(new Solution().findMinDifference(Arrays.asList("00:00", "23:59", "00:00")));
        System.out.println(new Solution().findMinDifference(Arrays.asList("05:31", "22:08", "00:35")));
    }
}