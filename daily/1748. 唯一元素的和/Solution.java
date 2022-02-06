import java.util.HashMap;
import java.util.Map;

class Solution {
    public int sumOfUnique(int[] nums) {
        int result = 0;
        Map<Integer, Integer> numToCount = new HashMap<>();
        for(Integer num : nums) {
            numToCount.put(num, numToCount.getOrDefault(num, 0) + 1);
        }
        for(Integer num : numToCount.keySet()) {
            if(numToCount.get(num) == 1) {
                result += num;
            }
        }
        return result;
    }
}