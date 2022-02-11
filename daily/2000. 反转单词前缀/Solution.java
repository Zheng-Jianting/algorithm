class Solution {
    public String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch);
        if(index == -1) {
            return word;
        }
        else if(index == word.length() - 1) {
            return new StringBuilder(word).reverse().toString();
        }
        else {
            return new StringBuilder(word.substring(0, index + 1)).reverse().toString() + word.substring(index + 1);
        }
    }
}