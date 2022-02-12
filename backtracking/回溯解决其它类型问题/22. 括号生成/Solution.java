import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Solution {
    private List<String> result;
    private int n;
    private int leftCount, rightCount; // 剪枝

    public List<String> generateParenthesis(int n) {
        result = new LinkedList<>();
        this.n = n;
        leftCount = rightCount = 0;
        dfs(0, new LinkedList<>());
        return result;
    }

    private void dfs(int i, LinkedList<Character> parenthesis) {
        if(i == 2 * n && leftCount == rightCount) {
            if(isCorrect(parenthesis)) {
                StringBuilder builder = new StringBuilder();
                for(Character ch : parenthesis) {
                    builder.append(ch);
                }
                result.add(builder.toString());
            }
        }
        else if(i < 2 * n && leftCount <= n && rightCount <= n && rightCount <= leftCount) { // 右括号的数量不能多于左括号的数量(容易漏掉的剪枝条件)
            parenthesis.add('(');
            leftCount++;
            dfs(i + 1, parenthesis);
            parenthesis.removeLast();
            leftCount--;

            parenthesis.add(')');
            rightCount++;
            dfs(i + 1, parenthesis);
            parenthesis.removeLast();
            rightCount--;
        }
    }

    private boolean isCorrect(LinkedList<Character> parenthesis) {
        Deque<Character> stack = new ArrayDeque<>();
        for(Character ch : parenthesis) {
            if(ch == '(') {
                stack.push(ch);
            }
            else {
                if(stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }



    // Optimize
    public List<String> generateParenthesisOptimize(int n) {
        result = new LinkedList<>();
        this.n = n;
        dfsOptimize(0, 0, new String());
        return result;
    }

    private void dfsOptimize(int left, int right, String parenthesis) {
        if(left == n && right == n) {
            result.add(parenthesis);
        }
        if(left < n) {
            dfsOptimize(left + 1, right, parenthesis + "(");
        }
        if(left > right) {
            dfsOptimize(left, right + 1, parenthesis + ")");
        }
    }
}