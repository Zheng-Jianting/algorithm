class Solution {
    public void nextPermutation(int[] nums) {
        int i = -1;
        for (int k = nums.length - 1; k >= 1; k--) {
            if (nums[k] > nums[k-1]) {
                i = k - 1;
                break;
            }
        }

        if (i == -1) {
            reverseArray(nums, 0, nums.length - 1);
        } else {
            int j = -1;
            for (int k = nums.length - 1; k > i; k--) {
                if (nums[k] > nums[i]) {
                    j = k;
                    break;
                }
            }

            swap(nums, i, j);
            reverseArray(nums, i + 1, nums.length - 1);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void reverseArray(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}