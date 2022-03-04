import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    // 时间复杂度 O(n^2) 空间复杂度 O(1)
    // 最直接的方法，遍历所有组合方式，看两个数是否相等
    public int findDuplicate(int[] nums) {
        int result = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if((nums[i] ^ nums[j]) == 0) { // or nums[i] == num[j]
                    result = nums[i];
                    break;
                }
            }
            
            if(result != 0) {
                break;
            }
        }
        return result;
    }

    // 时间复杂度 O(n) 空间复杂度 O(1)
    public int findDuplicateBitOperation(int[] nums) {
        int result = 0;

        int[] x = new int[32]; // x 存放 1 ~ n 按位相加后的结果
        int[] y = new int[32]; // y 存放 nums 数组按位相加后的结果

        for(int i = 1; i <= nums.length - 1; i++) { // 计算 x，遍历 1 ~ n
            for(int j = 0; j < 32; j++) { // 把 i 的每一位加到 x 中
                x[j] += (i >> (31 - j)) & 1;
            }
        }

        for(int i = 0; i < nums.length; i++) { // 计算 y，遍历  nums 数组
            for(int j = 0; j < 32; j++) {
                y[j] += (nums[i] >> (31 - j)) & 1;
            }
        }

        /**
         * 记重复多次的数为 target，先考虑重复 2 次的情况
         * 若 y[k] > x[k]，说明 target 的第 k 位是 1
         * 若 y[k] == x[k]，说明 target 的第 k 位是 0
         * 
         * 当 target 重复 3 次及以上时，理解为 target 替换了 1 ~ n 中缺失的数
         * 当 target 第 k 位是 1，y[k] > x[k]
         * 当 target 第 k 位是 0，且被替换的数第 k 位都是 0，y[k] == x[k]
         * 当 target 第 k 位是 0，且被替换的数第 k 位存在 1，y[k] < x[k]
         */
        for(int k = 0; k < 32; k++) {
            if(y[k] > x[k]) {
                result = (result << 1) + 1;
            }
            else {
                result = (result << 1) + 0;
            }
        }

        return result;
    }
}