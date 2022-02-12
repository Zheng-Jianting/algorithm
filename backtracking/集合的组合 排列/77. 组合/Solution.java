import java.util.LinkedList;
import java.util.List;

class Solution {
    private List<List<Integer>> result;

    public List<List<Integer>> combine(int n, int k) {
        result = new LinkedList<>();
        dfs(n, k, 1, new LinkedList<>());
        return result;
    }

    private void dfs(int n, int k, int i, LinkedList<Integer> combination) {
        if(combination.size() == k) {
            result.add(new LinkedList<>(combination));
        }
        else if(i > n || combination.size() + n - i + 1 < k) {
            return;
        }
        else {
            dfs(n, k, i + 1, combination);

            combination.add(i);
            dfs(n, k, i + 1, combination);
            combination.removeLast();
        }
    }
}