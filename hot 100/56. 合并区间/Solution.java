import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public int[][] merge(int[][] intervals) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        for (int[] interval : intervals) {
            heap.offer(interval);
        }
        List<int[]> rst = new LinkedList<>();
        while (!heap.isEmpty()) {
            int[] interval = heap.poll();
            while (!heap.isEmpty()) {
                if (interval[1] >= heap.peek()[0]) {
                    interval[1] = Math.max(interval[1], heap.peek()[1]);
                    heap.poll();
                } else {
                    break;
                }
            }
            rst.add(interval);
        }
        return rst.toArray(new int[0][]);
    }
}