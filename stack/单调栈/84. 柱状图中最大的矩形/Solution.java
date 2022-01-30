import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 从左向右遍历, 当遍历到当前高度时, 并不清楚在右边什么位置会出现更低的高度, 因此不能计算以其作为高的矩形面积
 * 因此维持一个单调栈, 栈内高度单调递增: 
 *      当遍历到的高度大于栈顶高度, 则将其压栈
 *      当高度小于栈顶高度, 那么以栈顶高度为高的矩形面积便可以计算, 因为宽度可以确定, 当前遍历到的高度是右边界, 左边界是栈中下一个高度
 * 为了方便计算宽度, 单调栈存下标, 高度可以通过下标得到
 * 为了方便处理边界, 栈中先压入下标 -1, 表示在下标 -1 处有一个高度最低的墙
 * 时间复杂度 O(n), 空间复杂度 O(n): 每个高度都入栈一次, 出栈一次, 出栈时会计算以其为高的矩形面积
 */
class Solution {
    public int largestRectangleArea(int[] heights) {
        int largestArea = Integer.MIN_VALUE;
        // Stack<Integer> stack = new Stack<Integer>();
        Deque<Integer> stack = new ArrayDeque<Integer>();
        stack.push(-1);
        for(int i = 0; i < heights.length; i++) {
            while(stack.peek() != -1 && heights[i] <= heights[stack.peek()]) {
                int top = stack.pop();
                largestArea = Math.max(largestArea, heights[top] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }

        while(stack.peek() != -1) { // 此时栈内高度仍然是单调递增的, 并且以每一个高度作为矩形高度时, 矩形的宽可以一直向右延申
            int top = stack.pop();
            largestArea = Math.max(largestArea, heights[top] * (heights.length - stack.peek() - 1));
        }

        return largestArea;
    }
}