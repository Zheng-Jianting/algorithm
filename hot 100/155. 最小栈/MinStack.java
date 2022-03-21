import java.util.ArrayDeque;
import java.util.Deque;

class MinStack {
    Deque<Long> stack;
    int minValue;

    public MinStack() {
        stack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(0L);
            minValue = val;
        } else {
            stack.push(Long.valueOf(val) - minValue);
            minValue = Math.min(minValue, val);
        }
    }
    
    public void pop() {
        if (stack.peek() > 0L) {
            stack.pop();
        } else {
            minValue = (int) (minValue - stack.pop());
        }
    }
    
    public int top() {
        return stack.peek() > 0L ? (int) (minValue + stack.peek()) : minValue;
    }
    
    public int getMin() {
        return minValue;
    }
}