public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        int[] counts = new int[26];
        for(char ch : s.toCharArray()) {
            counts[ch - 'a']++;
        }
        for(char ch : t.toCharArray()) {
            if(counts[ch - 'a'] == 0) {
                return false;
            }
            counts[ch - 'a']--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isAnagram("anagram", "nagaram"));
        System.out.println(new Solution().isAnagram("rat", "car"));
    }
}