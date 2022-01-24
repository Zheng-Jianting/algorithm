import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) {
            return "";
        }

        int minStart = 0, minEnd = Integer.MAX_VALUE - 1;
        Map<Character, Integer> sCharToCount = new HashMap<>(); // 统计 s 中各个字符出现的次数
        Map<Character, Integer> tCharToCount = new HashMap<>(); // 统计 t 中各个字符出现的次数
        for(int k = 0; k < t.length(); k++) {
            sCharToCount.put(t.charAt(k), 0);
            tCharToCount.put(t.charAt(k), tCharToCount.getOrDefault(t.charAt(k), 0) + 1);
        }
        int i = 0, j = 0;
        while(j < s.length()) {
            if(tCharToCount.containsKey(s.charAt(j))) { // 若 t 中不包含字符 s[j], 直接跳过 s[j]
                sCharToCount.put(s.charAt(j), sCharToCount.get(s.charAt(j)) + 1);
                if(isAllInclude(sCharToCount, tCharToCount)) { // 若加入 s[j] 满足条件, 则左移左指针直至不包含 t 的全部字符
                    while(i <= j && isAllInclude(sCharToCount, tCharToCount)) {
                        if(tCharToCount.containsKey(s.charAt(i))) { // 若 t 中不包含字符 s[j], 直接跳过 s[i]
                            sCharToCount.put(s.charAt(i), sCharToCount.get(s.charAt(i)) - 1);
                        }
                        i++;
                    }
                    if((j - i + 2) < (minEnd - minStart + 1)) { // 此时 s[i-1, j] 是包含 t 所有字符的子串
                        minStart = i - 1;
                        minEnd = j;
                    }
                }
            }
            j++;
        }
        return (minEnd == Integer.MAX_VALUE - 1) ? "" : s.substring(minStart, minEnd + 1);
    }

    /**
     * 只有当 sCharToCount 中每个字符的数量都大于 tCharToCount 时, 才返回 true
     * sCharToCount 中的 key 于 tCharToCount 是一致的, 字符串 s 中存在但字符串 t 中不存在的字符并不会记录
     * @param sCharToCount
     * @param tCharToCount
     * @return
     */
    public boolean isAllInclude(Map<Character, Integer> sCharToCount, Map<Character, Integer> tCharToCount) {
        boolean result = true;
        for(Character key : sCharToCount.keySet()) {
            if(sCharToCount.get(key) < tCharToCount.get(key)) {
                return false;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(new Solution().minWindow("a", "a"));
        System.out.println(new Solution().minWindow("a", "aa"));
        System.out.println(new Solution().minWindow("a", "b"));
    }
}