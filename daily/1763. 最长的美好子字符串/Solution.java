import java.util.HashSet;
import java.util.Set;

class Solution {
    public String longestNiceSubstring(String s) {
        int maxLength = Integer.MIN_VALUE;
        int start = 0;
        for(int i = 0; i < s.length(); i++) {
            for(int j = i + 1; j < s.length(); j++) {
                if(isBeautifulOptimize(s.substring(i, j + 1)) && j - i + 1 > maxLength) {
                    maxLength = j - i + 1;
                    start = i;
                }
            }
        }
        return maxLength == Integer.MIN_VALUE ? "" : s.substring(start, start + maxLength);
    }

    private boolean isBeautiful(String s) {
        Set<Character> set = new HashSet<>();
        for(Character ch : s.toCharArray()) {
            set.add(ch);
        }
        for(Character ch : s.toCharArray()) {
            if(Character.isLowerCase(ch) && !set.contains(Character.toUpperCase(ch))) {
                return false;
            }
            if(Character.isUpperCase(ch) && !set.contains(Character.toLowerCase(ch))) {
                return false;
            }
        }
        return true;
    }

    private boolean isBeautifulOptimize(String s) {
        int upper = 0;
        int lower = 0;
        for(char ch : s.toCharArray()) {
            if(Character.isUpperCase(ch)) {
                upper |= 1 << (ch - 'a');
            }
            else {
                lower |= 1 << (ch - 'a');
            }
        }
        return upper == lower;
    }
}