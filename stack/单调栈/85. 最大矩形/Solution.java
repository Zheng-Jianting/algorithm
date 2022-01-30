import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        int maxArea = Integer.MIN_VALUE;
        int[] height = new int[matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                height[j] = (matrix[i][j] == '0') ? 0 : height[j] + 1;
            }
            Deque<Integer> stack = new ArrayDeque<Integer>();
            stack.push(-1);
            for(int k = 0; k < height.length; k++) {
                while(stack.peek() != - 1 && height[k] <= height[stack.peek()]) {
                    int top = stack.pop();
                    maxArea = Math.max(maxArea, height[top] * (k - stack.peek() - 1));
                }
                stack.push(k);
            }
            while(stack.peek() != -1) {
                int top = stack.pop();
                maxArea = Math.max(maxArea, height[top] * (height.length - stack.peek() - 1));
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[4][5];
        matrix[0] = new char[] { '1', '0', '1', '0', '0' };
        matrix[1] = new char[] { '1', '0', '1', '1', '1' };
        matrix[2] = new char[] { '1', '1', '1', '1', '1' };
        matrix[3] = new char[] { '1', '0', '0', '1', '0' };
        System.out.println(new Solution().maximalRectangle(matrix));
    }
}