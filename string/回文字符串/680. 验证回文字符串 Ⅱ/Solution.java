/**
 * 本题字符串 s 只由小写字母构成, 不像 T125 一样由 ASCII 构成
 * 速度慢了点, 懒得改了
 */
public class Solution {
    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while(i < j) {
            while(i < s.length() && !Character.isLetterOrDigit(s.charAt(i))) { i++; }
            while(j >= 0 && !Character.isLetterOrDigit(s.charAt(j))) { j--; }
            if(i >= j) {
                return true;
            }
            else if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return isPalindrome(s.substring(i + 1, j + 1)) || isPalindrome(s.substring(i, j));
            }
            else {
                i++;
                j--;
            }
        }
        return true;
    }

    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while(i < j) {
            while(i < s.length() && !Character.isLetterOrDigit(s.charAt(i))) { i++; }
            while(j >= 0 && !Character.isLetterOrDigit(s.charAt(j))) { j--; }
            if(i >= j) {
                return true;
            }
            else if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            else {
                i++;
                j--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().validPalindrome("aba"));
        System.out.println(new Solution().validPalindrome("abca"));
        System.out.println(new Solution().validPalindrome("abc"));
        System.out.println(new Solution().validPalindrome(""));
    }
}