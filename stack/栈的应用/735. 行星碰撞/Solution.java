import java.util.Stack;

// 遍历到当前行星时, 能够判断其是否会和之前的行星相撞, 但不能判断是否会和之后的行星相撞, 因此先用栈存储
public class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<Integer>();
        for(int asteroid : asteroids) {
            if(asteroid > 0) { // 向右行驶的行星直接压栈即可
                stack.push(asteroid);
            }
            else { // 行星是向左行驶的
                if(stack.isEmpty() || stack.peek() < 0) { // 若栈为空或栈顶行星也是向左行驶的, 直接压栈即可
                    stack.push(asteroid);
                }
                else { // 和栈顶行星相向而行, 根据质量大小讨论
                    int lastPop = 0;
                    while(!stack.isEmpty() && stack.peek() > 0 && stack.peek() <= -asteroid) {
                        lastPop = stack.pop();
                        if(lastPop == -asteroid) {
                            break;
                        }
                    }
                    /**
                     * lastPop == 0: 一开始就被栈顶行星撞死了, 因为第一次进 while 条件 !stack.isEmpty() && stack.peek() > 0 必为 true
                     * lastPop == -asteroid: 和最后一颗质量相同的行星一起撞死了
                     * !stack.isEmpty() && stack.peek() > 0: 撞了一会, 最后被大行星撞死了
                     */
                    if(lastPop == 0 || lastPop == -asteroid || (!stack.isEmpty() && stack.peek() > 0)) {
                        continue;
                    }
                    stack.push(asteroid);
                }
            }
        }
        // stream 介绍: https://blog.csdn.net/lidai352710967/article/details/82496783
        return stack.stream().mapToInt(i -> i).toArray();
    }
}