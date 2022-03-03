class Solution {
    public int addDigits(int num) {
        while (num >= 10) {
            String strNum = String.valueOf(num);
            int temp = 0;
            for (char digit : strNum.toCharArray()) {
                temp += digit - '0';
            }
            num = temp;
        }
        return num;
    }
}