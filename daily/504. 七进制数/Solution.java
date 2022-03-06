class Solution {
    public String convertToBase7(int num) {
        boolean negative = num < 0;
        num = Math.abs(num);
        StringBuilder sb = new StringBuilder();
        while (num >= 7) {
            sb.append(num % 7);
            num /= 7;
        }
        sb.append(num);
        if (negative) 
            sb.append('-');
        return sb.reverse().toString();
    }
}