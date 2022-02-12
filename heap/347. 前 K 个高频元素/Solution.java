import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numToCount = new HashMap<>();
        Queue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((e1, e2) -> e1.getValue() - e2.getValue());
        for(int num : nums) {
            numToCount.put(num, numToCount.getOrDefault(num, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> entry : numToCount.entrySet()) {
            if(minHeap.size() < k) {
                minHeap.offer(entry);
            }
            else if(entry.getValue() > minHeap.peek().getValue()) {
                minHeap.poll();
                minHeap.offer(entry);
            }
        }

        int[] result = new int[k];
        int i = 0;
        for(Map.Entry<Integer, Integer> entry : minHeap) {
            result[i++] = entry.getKey();
        }
        return result;
    }
}