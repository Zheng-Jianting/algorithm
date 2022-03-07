import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Optimize {
    private List<List<Integer>> result;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        result = new LinkedList<>();
        dfs(candidates, target, 0, new LinkedList<Integer>(), 0);
        return result;
    }

    private void dfs(int[] candidates, int target, int i, LinkedList<Integer> combination, int sum) {
        if (target == sum) {
            result.add(new LinkedList<>(combination));
        }
        else if (i >= candidates.length || sum > target) {
            return;
        }
        else {
            combination.add(candidates[i]);
            dfs(candidates, target, i + 1, combination, sum + candidates[i]);
            combination.removeLast();

            while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
                i++;
            }
            dfs(candidates, target, i + 1, combination, sum);
        }
    }
}