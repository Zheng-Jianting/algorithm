public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() -1; // 从 a 的末尾向前遍历
        int j = b.length() - 1; // 从 b 的末尾向前遍历
        int carry = 0; // 进位

        while(i >= 0 || j >= 0) { // 直到 a，b 都遍历完
            int digitA = i >= 0 ? a.charAt(i--) - '0' : 0;
            int digitB = j >= 0 ? b.charAt(j--) - '0' : 0;
            int sum = (digitA + digitB + carry) % 2;
            carry = (digitA + digitB + carry) / 2;
            result.append(sum);
        }

        if(carry != 0) {
            result.append(carry);
        }

        return result.reverse().toString(); // result 添加顺序是从低位到高位，因此需要反转
    }
}