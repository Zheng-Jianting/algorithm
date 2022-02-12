import java.util.PriorityQueue;
import java.util.Queue;

class KthLargest {
    Queue<Integer> minHeap;
    int heapSize;

    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>((a, b) -> a - b);
        heapSize = k;
        for(int num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        if(minHeap.size() < heapSize) {
            minHeap.offer(val);
        }
        else if(val > minHeap.peek()) {
            minHeap.poll();
            minHeap.offer(val);
        }
        return minHeap.peek();
    }
}