import java.util.LinkedList;
import java.util.List;

class Solution {
    private List<List<String>> result;

    public List<List<String>> partition(String s) {
        result = new LinkedList<>();
        dfs(s, new LinkedList<>());
        return result;
    }

    private void dfs(String s, LinkedList<String> curList) {
        if(s.isEmpty()) {
            result.add(new LinkedList<>(curList));
        }
        else {
            for(int i = 1; i <= s.length(); i++) {
                String str = s.substring(0, i);
                if(isPalindrome(str)) {
                    curList.add(str);
                    if(i == s.length()) {
                        dfs("", curList);
                    }
                    else {
                        dfs(s.substring(i, s.length()), curList);
                    }
                    curList.removeLast();
                }
            }
        }
    }

    private boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}