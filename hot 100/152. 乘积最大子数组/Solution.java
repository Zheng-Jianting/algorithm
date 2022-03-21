class Solution {
    public int maxProduct(int[] nums) {
        int minProduct = 1, maxProduct = 1, rst = nums[0];
        for (int num : nums) {
            int a = num * minProduct, b = num * maxProduct;
            minProduct = Math.min(Math.min(a, b), num);
            maxProduct = Math.max(Math.max(a, b), num);
            rst = Math.max(rst, maxProduct);
        }
        return rst;
    }
}