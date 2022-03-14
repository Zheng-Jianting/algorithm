import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
    Set<String> set;
    Map<String, Boolean> map;

    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>();
        for (String word : wordDict) {
            set.add(word);
        }
        map = new HashMap<>();
        return dfs(s);
    }

    private boolean dfs(String s) {
        if (s.isEmpty()) {
            return true;
        }
        if (map.containsKey(s)) {
            return map.get(s);
        }
        for (int i = 1; i <= s.length(); i++) {
            if (set.contains(s.substring(0, i))) {
                if (dfs(s.substring(i, s.length()))) {
                    map.put(s, true);
                    return true;
                }
            }
        }
        map.put(s, false);
        return false;
    }
}