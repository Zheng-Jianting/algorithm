import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    // O(k^2 log(k))
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        Queue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] + b[1] - a[0] - a[1]);
        for(int i = 0; i < k && i < nums1.length; i++) {
            for(int j = 0; j < k && j < nums2.length; j++) {
                if(maxHeap.size() < k) {
                    maxHeap.offer(new int[] { nums1[i], nums2[j] });
                } else if(nums1[i] + nums2[j] < maxHeap.peek()[0] + maxHeap.peek()[1]) {
                    maxHeap.poll();
                    maxHeap.offer(new int[] { nums1[i], nums2[j] });
                }
            }
        }

        List<List<Integer>> result = new LinkedList<>();
        while(!maxHeap.isEmpty()) {
            int[] pair = maxHeap.poll();
            result.add(Arrays.asList(pair[0], pair[1]));
        }
        result.sort((a, b) -> a.get(0) + a.get(1) - b.get(0) - b.get(1));
        return result;
    }

    // O(k log(k))
    public List<List<Integer>> kSmallestPairsOptimize(int[] nums1, int[] nums2, int k) {
        Queue<int[]> minHeap = new PriorityQueue<>((p1, p2) -> nums1[p1[0]] + nums2[p1[1]] - nums1[p2[0]] - nums2[p2[1]]);
        for(int i = 0; i < Math.min(k, nums1.length); i++) {
            minHeap.offer(new int[] { i, 0 });
        }
        List<List<Integer>> result = new LinkedList<>();
        while(k-- > 0 && !minHeap.isEmpty()) {
            int[] pair = minHeap.poll();
            result.add(Arrays.asList(nums1[pair[0]], nums2[pair[1]]));
            if(pair[1] < nums2.length - 1) {
                minHeap.offer(new int[] { pair[0], pair[1] + 1 });
            }
        }
        result.sort((a, b) -> a.get(0) + a.get(1) - b.get(0) - b.get(1));
        return result;
    }
}