import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()) {
            return 0;
        }
        int maxLength = Integer.MIN_VALUE;
        Map<Character, Integer> charToCount = new HashMap<>(); // 无重复 即每个字符出现次数均为 1
        int i = 0, j = 0;
        while(j < s.length()) {
            charToCount.put(s.charAt(j), charToCount.getOrDefault(s.charAt(j), 0) + 1);
            while(i < j && charToCount.get(s.charAt(j)) == 2) { //若当前遍历的元素出现过 那么左移左指针直至其数量为 1
                charToCount.put(s.charAt(i), charToCount.get(s.charAt(i)) - 1);
                i++;
            } // 此时区间 [i, j] 是无重复字符的
            j++;
            maxLength = Math.max(maxLength, j - i);
        }
        return maxLength == Integer.MIN_VALUE ? 0 : maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new Solution().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new Solution().lengthOfLongestSubstring("pwwkew"));
    }
}