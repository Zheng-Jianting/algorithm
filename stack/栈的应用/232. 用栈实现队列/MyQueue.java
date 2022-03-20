import java.util.ArrayDeque;
import java.util.Deque;

class MyQueue {
    int stack1Bottom; // for peek
    Deque<Integer> stack1;
    Deque<Integer> stack2;

    public MyQueue() {
        stack1 = new ArrayDeque<Integer>();
        stack2 = new ArrayDeque<Integer>();
    }
    
    public void push(int x) {
        if (stack1.isEmpty()) {
            stack1Bottom = x;
        }
        stack1.push(x);
    }
    
    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
    
    public int peek() {
        if (!stack2.isEmpty()) {
            return stack2.peek();
        }
        return stack1Bottom;
    }
    
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}