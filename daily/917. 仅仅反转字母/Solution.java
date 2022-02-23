class Solution {
    public String reverseOnlyLetters(String s) {
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()) {
            if(Character.isLetter(ch)) {
                sb.append(ch);
            }
        }
        String reverse = sb.reverse().toString();

        StringBuilder result = new StringBuilder();
        int k = 0;
        for(int i = 0; i < s.length(); i++) {
            char ch = Character.isLetter(s.charAt(i)) ? reverse.charAt(k++) : s.charAt(i);
            result.append(ch);   
        }

        return result.toString();
    }
}