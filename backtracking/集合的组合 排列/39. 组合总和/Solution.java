import java.util.LinkedList;
import java.util.List;

class Solution {
    private List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new LinkedList<>();
        dfs(candidates, target, 0, 0, new LinkedList<>());
        return result;
    }

    private void dfs(int[] candidates, int target, int i, int sum, LinkedList<Integer> combination) {
        if(sum == target) {
            result.add(new LinkedList<>(combination));
        }
        else if(i >= candidates.length || sum > target) {
            return;
        }
        else {
            dfs(candidates, target, i + 1, sum, combination);

            combination.add(candidates[i]);
            dfs(candidates, target, i, sum + candidates[i], combination);
            combination.removeLast();
        }
    }
}