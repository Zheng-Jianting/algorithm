import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) {
            return false;
        }

        Map<Character, Integer> charToCount = new HashMap<>();
        for(int k = 0; k < s1.length(); k++) {
            charToCount.put(s1.charAt(k), charToCount.getOrDefault(s1.charAt(k), 0) + 1);
        }

        int i = 0, j = s1.length() - 1;
        for(int k = i; k <= j; k++) {
            if(charToCount.containsKey(s2.charAt(k))) {
                charToCount.put(s2.charAt(k), charToCount.get(s2.charAt(k)) - 1);
            }
        }
        if(isAllZero(charToCount)) {
            return true;
        }

        for(i++, j++; j < s2.length(); i++, j++) {
            if(charToCount.containsKey(s2.charAt(i - 1))) {
                charToCount.put(s2.charAt(i - 1), charToCount.get(s2.charAt(i - 1)) + 1);
            }
            if(charToCount.containsKey(s2.charAt(j))) {
                charToCount.put(s2.charAt(j), charToCount.get(s2.charAt(j)) - 1);
            }
            if(isAllZero(charToCount)) {
                return true;
            }
        }

        return false;
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
        System.out.println(new Solution().checkInclusion("ab", "eidbaooo"));
        System.out.println(new Solution().checkInclusion("ab", "eidboaoo"));
    }
}