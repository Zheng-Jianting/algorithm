import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int result = Integer.MAX_VALUE;
        for(int i = k - 1; i < nums.length; i++) {
            result = Math.min(result, Math.abs(nums[i] - nums[i - k + 1]));
        }
        return result;
    }

    public int maximumDifference(int[] nums, int k) {
        Queue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
        int maxValue = Integer.MIN_VALUE;
        for(int num : nums) {
            if(minHeap.size() < k) {
                minHeap.offer(num);
                maxValue = Math.max(maxValue, num);
            }
            else if(num > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(num);
                maxValue = Math.max(maxValue, num);
            }
        }
        return maxValue - minHeap.peek();
    }
}