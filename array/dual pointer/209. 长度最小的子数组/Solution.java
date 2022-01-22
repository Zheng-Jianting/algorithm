public class Solution {
    public int minSubArrayLen(int target, int[] nums) { // nums 是正数数组 指针向右移动区间和增大 因此可以用双指针
        int minLength = Integer.MAX_VALUE;
        int i = 0, j = 0, sum = 0; // sum 表示 nums 数组 [i, j) 区间和
        while(j < nums.length) {
            sum += nums[j++];
            if(sum >= target) { // 右指针向右移动 直至区间和大于等于 target
                while (i < j && sum >= target) { // 左指针向右移动 直至区间和小于 target
                    sum -= nums[i++];
                }
                minLength = Math.min(minLength, j - i + 1); // 区间 [i, j) 长度原是 j-i 加一是指少减一个才满足区间和大于等于 target
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minSubArrayLen(7, new int[] {2, 3, 1, 2, 4, 3}));
    }
}