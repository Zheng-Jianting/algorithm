public class Solution {
    public int divide(int devidend, int devisor) {
        if(devidend == 0x80000000 && devisor == -1) { // int 范围 [-2^31, 2^31-1]，-2^31 / -1 会溢出，0x80000000 为 -2^31(-2147483648) 的补码
            return Integer.MAX_VALUE;
        }
        
        int negative = 2; // 负数的数量
        if(devidend > 0) { // 将被除数和除数都转换成负数，若都转换成正数可能会发生溢出：-2^31
            devidend = -devidend;
            negative--;
        }

        if(devisor > 0) {
            devisor = -devisor;
            negative--;
        }

        int result = devideCore(devidend, devisor);

        return negative == 1 ? -result : result;
    }

    public int devideCore(int devidend, int devisor) {
        int quotient = 0;

        while(devidend <= devisor) {
            int k = 1; // 初始化商的增量为 1 表示被除数至少能减一次除数
            int value = devisor;

            // 并且需要特别注意的是 value 必须 >= -2^30，补码为 c0000000，不然 value + value 会溢出
            while(value >= 0xc0000000 && (value + value) >= devidend) { // value 表示不断将除数翻倍，直到小于被除数为止
                value += value;
                k += k; // value 翻倍表示除数被减的次数也翻倍了，因此商的增量也应当翻倍
            }

            devidend -= value;
            quotient += k;
        }

        return quotient;
    }
}