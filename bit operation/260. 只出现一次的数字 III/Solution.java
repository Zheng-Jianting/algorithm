public class Solution {
    // x & -x，x 为 -2^31 时会溢出，但 -x == x == 0x80000000，结果还是对的
    public int[] singleNumber(int[] nums) {
        int xorSum = 0; // 异或结果
        for(int i = 0; i < nums.length; i++) { // 相同的值异或后为 0，因此 xorSum 为两个只出现一次的值异或后的结果
            xorSum ^= nums[i];
        }

        // 位运算只保留 x 的 lsb(least significant bit)：x & -x
        // 以 int(-2^31, 2^31-1) 为例，x 为 -2^31 时会溢出，但 -2^31(0x80000000) 本身就只保留了 lsb
        int lsb = xorSum == Integer.MIN_VALUE ? xorSum : xorSum & -xorSum; // 只保留 xorSum 的 lsb，该位为 1 说明两个只出现一次的值在该位一个是 0，一个是 1
        
        // 依据 lsb 的值对 nums 分类，再对这两类异或便得到了两个只出现一次的值
        int x = 0, y = 0;
        for(int i = 0; i < nums.length; i++) {
            if((nums[i] & lsb) == 0) { // 说明 nums[i] 属于 lsb 为 0 的一类
                x ^= nums[i];
            }
            else { // 说明 nums[i] 属于 lsb 为 1 的一类
                y ^= nums[i];
            }
        }

        return new int[] {x, y};
    }
}