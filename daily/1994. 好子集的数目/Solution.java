/**
 * f[i][j] 表示选择的元素值为 i(2 <= i <= 30), 并且 30 以内的 10 个质数的使用情况为 j(10 bit) 时的好子集数目
 * f[i][j] = f[i-1][j] 当 i 的质因子有重复时, 那么 i 肯定不能选
 * f[i][j] = f[i-1][j] + f[i-1][j ^ mask_i] * count(i), 不选或选 i, 选 i 的前提是 j 表示的质数使用情况能够满足选择 i 的需求, 即 j & mask_i == mask_i
 * result = f[30][(1 << 10) - 1]
 * f[1][j] = pow(2, count(1)) 1 可选可不选
 */
class Solution {
    static final int[] primes = new int[] {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
    static final int MAX_VAL = 30;
    static final int MOD = 1000000007;

    public int numberOfGoodSubsets(int[] nums) {
        int[] count = new int[MAX_VAL + 1];
        for(int num : nums) {
            count[num]++;
        }

        int[][] dp = new int[2][1 << 10];
        for(int i = 1; i <= MAX_VAL; i++) {
            if(count[i] == 0) {
                continue;
            }

            for(int j = 0; j <= (1 << 10) - 1; j++) {
                if(i == 1) {
                    dp[i % 2][j] = 1;
                    for(int k = 0; k < count[1]; k++) {
                        dp[i % 2][j] = dp[i % 2][j] * 2 % MOD;
                    }
                }
                else {
                    boolean check = true;
                    int temp_i = i;
                    int i_mask = 0;
                    for(int k = 0; k < primes.length; k++) {
                        int prime = primes[k];
                        if(temp_i % (prime * prime) == 0) {
                            check = false;
                            break;
                        }
                        i_mask |= 1 << k;
                    }

                    if(!check) {
                        dp[i % 2][j] = dp[(i - 1) % 2][j];
                        continue;
                    }

                    dp[i % 2][j] = (j & i_mask) == i_mask ? dp[(i-1) % 2][j] + dp[(i-1) % 2][j ^ i_mask] : dp[(i-1) % 2][j];
                }
            }
        }

        return dp[MAX_VAL % 2][(1 << 10) - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numberOfGoodSubsets(new int[] {1, 2, 3, 4}));
    }
}