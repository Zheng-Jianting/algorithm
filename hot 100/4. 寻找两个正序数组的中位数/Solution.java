class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int cnt = (nums1.length + nums2.length) / 2 + 1;
        int target = -1, prev = -1;
        int i = 0, j = 0;
        while ((cnt--) > 0) {
            prev = target;
            if (j >= nums2.length || (i < nums1.length && nums1[i] < nums2[j])) {
                target = nums1[i];
                i++;
            } else {
                target = nums2[j];
                j++;
            }
        }
        return (nums1.length + nums2.length) % 2 == 1 ? target : (double) (target + prev) / 2;
    }
}