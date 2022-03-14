import java.util.Arrays;

class Solution {
    public int[] sortArray(int[] nums) {
        int[] dst = Arrays.copyOf(nums, nums.length);
        mergeSort(nums, 0, nums.length, dst);
        return dst;
    }

    private void mergeSort(int[] src, int start, int end, int[] dst) {
        if (end - start <= 1) {
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(dst, start, mid, src);
        mergeSort(dst, mid, end, src);

        int i = start, j = mid, k = start;
        while (i < mid || j < end) {
            if (j == end || (i < mid && src[i] < src[j])) {
                dst[k++] = src[i++];
            } else {
                dst[k++] = src[j++];
            }
        }
    }
}