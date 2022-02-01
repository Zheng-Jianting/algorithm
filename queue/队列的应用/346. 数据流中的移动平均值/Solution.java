import java.util.ArrayDeque;
import java.util.Queue;

class MovingAverage {
    private int size;
    private Queue<Integer> queue;
    private int sum;

    public MovingAverage(int size) {
        this.size = size;
        queue = new ArrayDeque<Integer>();
        sum = 0;
    }
    
    public double next(int val) {
        queue.offer(val);
        sum += val;
        if(queue.size() > size) {
            sum -= queue.poll();
        }
        return (double) sum / queue.size();
    }
}