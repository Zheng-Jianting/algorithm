public class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) { // 由于 nums 是正数数组 向右移动右指针乘积变大 向右移动左指针乘积变小 因此可以用双指针
        int result = 0;
        int i = 0, j = 0, product = 1; // product 表示累乘 nums 区间 [i, j) 的乘积
        while(j < nums.length) {
            product *= nums[j++]; // 向右移动右指针 累乘至 product >= k
            if(product >= k) {
                while(i < j && product >= k) { // 向左移动左指针 至 product < k
                    product /= nums[i++];
                }
            }
            // result += (i == j) ? 0 : j - i; // 等价于 result += j - i; // i == j 表示 nums[i-1] >= k
            result += j - i; // 此时 [i, j) 乘积满足小于 k 且左指针 i 不断向右移动得到的子数组乘积也满足小于 k
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numSubarrayProductLessThanK(new int[] {10, 5, 2, 6}, 100));
        System.out.println(new Solution().numSubarrayProductLessThanK(new int[] {1, 2, 3}, 0));
    }
}