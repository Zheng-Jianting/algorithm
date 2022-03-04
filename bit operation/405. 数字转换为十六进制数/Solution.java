public class Solution {
    public String toHex(int num) {
        StringBuilder result = new StringBuilder();
        int[] bits = new int[32]; // 存储 num 的 32 位

        for(int i = 0; i < 32; i++) {
            bits[i] = (num >> (31 - i)) & 1;
            if(i % 4 == 3) { // 每处理 4 位，将其转成 16 进制
                int x = bits[i] + 2*bits[i-1] + 4*bits[i-2] + 8*bits[i-3];
                if(!(result.length() == 0 && x == 0)) { // 防止添加前导零
                    result.append((x > 9) ? (char)('a' + x - 10) : (char)('0' + x));
                }
            }
        }

        return result.length() == 0 ? "0" : result.toString(); // 注意判空
    }

    // 直接每次获取对应的 4 位，这样不用人为计算该 4 位的值，也节省空间
    public String toHexOptimize(int num) {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < 8; i++) {
            int digit = (num >> (4 * (7 - i)) & 0xf);
            if(!(result.length() == 0 && digit == 0)) {
                result.append((digit > 9) ? (char)('a' + digit - 10) : (char)('0' + digit));
            }
        }
        return result.length() == 0 ? "0" : result.toString();
    }
}