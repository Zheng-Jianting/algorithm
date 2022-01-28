public class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] charToValue = new int[26]; // 数组模拟哈希表, 根据字符在 order 中的次序将其映射到值
        for(int i = 0; i < 26; i++) {
            charToValue[order.charAt(i) - 'a'] = i;
        }

        for(int i = 0; i < words.length - 1; i++) {
            if(!isSorted(words[i], words[i + 1], charToValue)) {
                return false;
            }
        }

        return true;
    }

    private boolean isSorted(String word1, String word2, int[] charToValue) {
        int k = 0;
        while(k < word1.length() && k < word2.length()) {
            if(charToValue[word1.charAt(k) - 'a'] < charToValue[word2.charAt(k) - 'a']) {
                return true;
            }
            if(charToValue[word1.charAt(k) - 'a'] > charToValue[word2.charAt(k) - 'a']) {
                return false;
            }
            k++;
        }
        return k == word1.length();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isAlienSorted(new String[] { "hello", "leetcode" }, "hlabcdefgijkmnopqrstuvwxyz"));
        System.out.println(new Solution().isAlienSorted(new String[] { "word", "world", "row" }, "worldabcefghijkmnpqstuvxyz"));
        System.out.println(new Solution().isAlienSorted(new String[] { "apple", "app" }, "abcdefghijklmnopqrstuvwxyz"));
    }
}