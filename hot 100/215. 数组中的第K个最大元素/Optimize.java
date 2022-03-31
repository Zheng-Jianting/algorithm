import java.util.Random;

class Optimize {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int start = 0, end = n - 1;
        int index = partition(nums, start, end);
        while (index != n - k) {
            if (index < n - k) {
                start = index + 1;
            } else {
                end = index - 1;
            }
            index = partition(nums, start, end);
        }
        return nums[index];
    }

    public int partition(int[] nums, int start, int end) {
        int random = start + new Random().nextInt(end - start + 1);
        swap(nums, random, end);

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

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}