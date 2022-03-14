import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int rst = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int len = 1;
                while (set.contains(num + 1)) {
                    len++;
                    num++;
                }
                rst = Math.max(rst, len);
            }
        }
        return rst == Integer.MIN_VALUE ? 1 : rst; 
    }
}