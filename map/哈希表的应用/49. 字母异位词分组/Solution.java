import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
    // 以排序后的字符串作为 key 进行分组
    public List<List<String>> groupAnagrams(String[] strs) {
        // Arrays.sort(strs);
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sorted = new String(charArray); // 注意 char 数组转 String 不能直接 toString()

            map.putIfAbsent(sorted, new LinkedList<String>());
            map.get(sorted).add(str);
        }
        return new LinkedList<>(map.values());
    }

    // 以每个字符出现的次数作为 key 进行分组, 如 "abb" 的 key 是: a1b2
    public List<List<String>> groupAnagramsByCount(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            int[] counts = new int[26];
            for(char ch : str.toCharArray()) {
                counts[ch - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 26; i++) {
                if(counts[i] != 0) {
                    sb.append((char) ('a' + i));
                    sb.append(counts[i]);
                }
            }
            String key = sb.toString();
            map.putIfAbsent(key, new LinkedList<String>());
            map.get(key).add(str);
        }
        return new LinkedList<>(map.values());
    }

    // 还可以将 26 个字母分别对应一个质数, 将字符串乘积作为 key, 但有可能会溢出

    public static void main(String[] args) {
        String[] strs = new String[] { "eat", "tea", "tan", "ate", "nat", "bat" };
        System.out.println(new Solution().groupAnagrams(strs));
        System.out.println(new Solution().groupAnagramsByCount(strs));
    }
}