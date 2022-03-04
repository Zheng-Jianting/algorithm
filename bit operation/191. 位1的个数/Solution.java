public class Solution {
    public int hammingWeight(int n) {
        // x & x-1 当 x == -2^31(0x80000000) 会溢出，但结果是正确的
        // -2^31-1 == 2^31-1，-2^31 & 2^31-1 == 0，确实消除了 -2^31 最右边的 1，if 不要也可以
        if(n == Integer.MIN_VALUE) {
            return 1;
        }

        int result = 0;
        while(n != 0) { // 不断消除 n 最右边的 1 直至为 n == 0
            n = n & (n-1); // x & x-1 结果会消除 x 最右边的 1
            result++;
        }
        return result;
    }
}