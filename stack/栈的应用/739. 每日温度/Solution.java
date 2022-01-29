import java.util.Stack;

// 遍历到当前温度时, 其可能比之前温度更高, 并不清楚何时会遇到更高的温度, 因此更新完之前的值后将其压栈
public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<Integer>(); // 单调栈, 存的是下标, 对应的温度非递增
        for(int i = 0; i < temperatures.length; i++) {
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                result[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return result;
    }
}