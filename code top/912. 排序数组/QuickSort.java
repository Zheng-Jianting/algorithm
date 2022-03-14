import java.util.Random;

class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int start, int end) {
        if (end > start) {
            int k = partition(nums, start, end);
            quickSort(nums, start, k - 1);
            quickSort(nums, k + 1, end);
        }
    }

    private int partition(int[] nums, int start, int end) {
        int randomIdx = start + new Random().nextInt(end - start + 1);
        swap(nums, randomIdx, end);

        int k = start - 1;
        for (int i = start; i < end; i++) {
            if (nums[i] < nums[end]) {
                k++;
                swap(nums, k, i);
            }
        }

        k++;
        swap(nums, k, end);

        return k;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}