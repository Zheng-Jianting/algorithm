import java.util.ArrayDeque;
import java.util.Queue;

class RecentCounter {
    private final int length = 3000;
    private Queue<Integer> queue;

    public RecentCounter() {
        queue = new ArrayDeque<Integer>();
    }
    
    public int ping(int t) {
        queue.offer(t);
        while(!queue.isEmpty() && queue.peek() < t - length) {
            queue.poll();
        }
        return queue.size();
    }
}