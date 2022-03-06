import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        if (security.length < 2 * time + 1) {
            return new LinkedList<Integer>();
        }

        int[] front = new int[security.length];
        for (int i = 1; i < security.length; i++) {
            if (security[i - 1] >= security[i]) {
                front[i] = front[i - 1] + 1;
            }
        }
        int[] back = new int[security.length];
        for (int i = security.length - 2; i >= 0; i--) {
            if (security[i] <= security[i + 1]) {
                back[i] = back[i + 1] + 1;
            }
        }

        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < security.length; i++) {
            if (front[i] >= time && back[i] >= time) {
                result.add(i);
            }
        }
        return result;
    }
}