import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution {
    private List<List<Integer>> result;
    private List<Integer> nums;
    private List<Integer> counts;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result = new LinkedList<>();
        Map<Integer, Integer> numToCount = new HashMap<>();
        for(int num : candidates) {
            numToCount.put(num, numToCount.getOrDefault(num, 0) + 1);
        }
        nums = new ArrayList<>(numToCount.keySet());
        counts = new ArrayList<>(numToCount.values());
        dfs(target, 0, 0, new LinkedList<>());
        return result;
    }

    private void dfs(int target, int i, int sum, LinkedList<Integer> combination) {
        if(target == sum) {
            result.add(new LinkedList<>(combination));
        }
        else if(i >= nums.size() || sum > target) {
            return;
        }
        else {
            dfs(target, i + 1, sum, combination);

            if(counts.get(i) > 0) {
                combination.add(nums.get(i));
                counts.set(i, counts.get(i) - 1);
                dfs(target, i, sum + nums.get(i), combination);
                combination.removeLast();
                counts.set(i, counts.get(i) + 1);
            }
        }
    }
}