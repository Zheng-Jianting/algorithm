import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new LinkedList<>();
        if(s.length() < p.length()) {
            return result;
        }

        Map<Character, Integer> charToCount = new HashMap<>();
        for(int k = 0; k < p.length(); k++) {
            charToCount.put(p.charAt(k), charToCount.getOrDefault(p.charAt(k), 0) + 1);
        }

        int i = 0, j = p.length() - 1;
        for(int k = i; k <= j; k++) {
            if(charToCount.containsKey(s.charAt(k))) {
                charToCount.put(s.charAt(k), charToCount.get(s.charAt(k)) - 1);
            }
        }
        if(isAllZero(charToCount)) {
            result.add(i);
        }

        for(i++, j++; j < s.length(); i++, j++) {
            if(charToCount.containsKey(s.charAt(i - 1))) {
                charToCount.put(s.charAt(i - 1), charToCount.get(s.charAt(i - 1)) + 1);
            }
            if(charToCount.containsKey(s.charAt(j))) {
                charToCount.put(s.charAt(j), charToCount.get(s.charAt(j)) - 1);
            }
            if(isAllZero(charToCount)) {
                result.add(i);
            }
        }

        return result;
    }

    public boolean isAllZero(Map<Character, Integer> charToCount) {
        boolean[] result = new boolean[] { true };
        charToCount.forEach((key, value) -> {
            if(value != 0) {
                result[0] = false;
                return;
            }
        });
        return result[0];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findAnagrams("cbaebabacd", "abc"));
        System.out.println(new Solution().findAnagrams("abab", "ab"));
    }
}