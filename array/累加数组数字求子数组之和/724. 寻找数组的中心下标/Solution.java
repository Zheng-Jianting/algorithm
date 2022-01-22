public class Solution {
    public int pivotIndex(int[] nums) {
        int result = -1;
        int[] forward = new int[nums.length]; // 正向求和
        int[] reverse = new int[nums.length]; // 逆向求和
        for(int i = 0; i < nums.length; i++) {
            forward[i] = (i == 0) ? nums[i] : forward[i-1] + nums[i];
            reverse[i] = (i == 0) ? nums[nums.length - 1] : reverse[i-1] + nums[nums.length - i - 1];
        }
        if(reverse[nums.length - 2] == 0) { // 0 为中心下标
            return 0;
        }
        for(int i = 1; i < nums.length - 1; i++) { // tips: 正向下标为 i 则逆向下标为 nums.length - i - 1
            if(forward[i-1] == reverse[nums.length - i - 2]) {
                return i;
            }
        }
        if(forward[nums.length - 2] == 0) { // nums.length - 1 为中心下标
            return nums.length - 1;
        } 
        return result;
    }

    public int pivotIndexPrefixSum(int[] nums) {
        int result = -1, total = 0, sum = 0;
        for(int i: nums) { // 先累加求和
            total += i;
        }
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if((sum - nums[i]) == total - sum) {
                return i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().pivotIndex(new int[] {1, 7, 3, 6, 5, 6}));
        System.out.println(new Solution().pivotIndex(new int[] {1, 2, 3}));

        System.out.println(new Solution().pivotIndexPrefixSum(new int[] {1, 7, 3, 6, 5, 6}));
        System.out.println(new Solution().pivotIndexPrefixSum(new int[] {1, 2, 3}));
    }
}