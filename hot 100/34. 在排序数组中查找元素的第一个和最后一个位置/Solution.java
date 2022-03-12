class Solution {
    public int[] searchRange(int[] nums, int target) {
        int k = search(nums, 0, nums.length - 1, target), i = k;
        while (k != -1) {
            k = search(nums, 0, k - 1, target);
            if (k != -1) {
                i = k;
            }
        }

        k = search(nums, 0, nums.length - 1, target);
        int j = k;
        while (k != -1) {
            k = search(nums, k + 1, nums.length - 1, target);
            if (k != -1) {
                j = k;
            }
        }

        return new int[] {i, j};
    }

    public static int search(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}