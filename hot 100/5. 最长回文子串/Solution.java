class Solution {
    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expend(s, i, i);
            int len2 = i + 1 < s.length() ? expend(s, i, i + 1) : 0;
            if (Math.max(len1, len2) > end - start + 1) {
                if (len1 > len2) {
                    start = i - len1 / 2;
                    end = i + len1 / 2;
                } else {
                    start = i - len2 / 2 + 1;
                    end = i + len2 / 2;
                }
            }
        }
        return s.substring(start, end + 1);
    }

    private int expend(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return j - i - 1;
    }
}