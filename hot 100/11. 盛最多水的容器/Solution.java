class Solution {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, rst = Integer.MIN_VALUE;
        while (i < j) {
            rst = Math.max(rst, (j - i) * Math.min(height[i], height[j]));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return rst;
    }
}