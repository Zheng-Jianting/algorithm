import java.util.HashMap;
import java.util.Map;

class Solution {
    // 把当前遍历的元素下标看成 i, 则要遍历两次, 并且需要两个哈希表
    public int countKDifference(int[] nums, int k) {
        int result = 0;
        Map<Integer, Integer> total = new HashMap<>();
        for(int num : nums) {
            total.put(num, total.getOrDefault(num, 0) + 1);
        }
        Map<Integer, Integer> current = new HashMap<>();
        for(int num : nums) {
            current.put(num, current.getOrDefault(num, 0) + 1);
            result += total.getOrDefault(num - k, 0) - current.getOrDefault(num - k, 0);
            result += total.getOrDefault(num + k, 0) - current.getOrDefault(num + k, 0);
        }
        return result;
    }

    // 若把当前遍历的元素下标看成 j, 则只需一个哈希表, 并且只用遍历一次
    public int countKDifferenceOptimize(int[] nums, int k) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            result += (map.containsKey(num - k) ? map.get(num - k) : 0);
            result += (map.containsKey(num + k) ? map.get(num + k) : 0);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return result;
    }
}