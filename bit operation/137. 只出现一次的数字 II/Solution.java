public class Solution {
    public int singleNumber(int[] nums) { // 若每个数字都出现 3 次，那么按位求和后，每一位 % 3 == 0
        int result = 0;
        int[] x = new int[32]; // nums 中的元素按位相加后的结果
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < 32; j++) { // 遍历 nums[i] 的 32 位
                x[j] += (nums[i] >> (31 - j)) & 1;
            }
        }
        for(int k = 0; k < 32; k++) {
            result = (result << 1) + (x[k] % 3 == 0 ? 0 : 1);
        }
        return result;
    }
}