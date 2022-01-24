public class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while(i < j) {
            while(i < s.length() && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while(j >= 0 && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
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
        System.out.println(new Solution().isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(new Solution().isPalindrome("race a car"));
        System.out.println(new Solution().isPalindrome("a."));
        System.out.println(new Solution().isPalindrome(""));
    }
}