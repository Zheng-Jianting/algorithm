public class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int i = 0; i < nums.length; i++) {
            result ^= nums[i]; // 任意两个相同的数异或结果为 0，任何数和 0 异或还是其本身，因此遍历数组执行异或操作就能找到只出现过一次的数
        }
        return result;
    }
}