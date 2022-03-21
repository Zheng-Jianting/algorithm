import java.util.ArrayDeque;
import java.util.Queue;

class MyStack {
    Queue<Integer> queue;

    public MyStack() {
        queue = new ArrayDeque<>();
    }
    
    public void push(int x) {
        int k = queue.size();
        queue.offer(x);
        while (k-- > 0) {
            queue.offer(queue.poll());
        }
    }
    
    public int pop() {
        return queue.poll();
    }
    
    public int top() {
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}