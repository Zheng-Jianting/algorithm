public class Solution {
    public int countSubstrings(String s) {
        int result = 0;
        for(int i = 0; i < s.length(); i++) {
            result += countPalindrome(s, i, i);
            result += countPalindrome(s, i, i + 1);
        }
        return result;
    }

    private int countPalindrome(String s, int i, int j) { // 计算以 s.charAt(i) 和 s.charAt(j) 为中心的回文字符串数量, i == j || i = j - 1
        if(j >= s.length()) {
            return 0;
        }

        int result = 0;
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            result++;
            i--;
            j++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countSubstrings("abc"));
        System.out.println(new Solution().countSubstrings("aaa"));
    }
}