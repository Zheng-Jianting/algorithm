import java.util.Arrays;

public class Solution {
    public int threeSumMulti(int[] arr, int target) {
        final int MOD = 1_000_000_007;
        long result = 0;
        int i, j, k;
        Arrays.sort(arr);
        for(i = 0; i < arr.length - 2; i++) {
            j = i + 1;
            k = arr.length - 1;
            while(j < k) {
                if(arr[j] + arr[k] < target - arr[i]) {
                    j++;
                }
                else if(arr[j] + arr[k] > target - arr[i]) {
                    k--;
                }
                else { // arr[i] + arr[j] + arr[k] == target
                    if(arr[j] == arr[k]) { // arr[j] 和 arr[k] 之间的数都是一样的
                        result += (k-j+1) * (k-j) / 2;
                        result %= MOD;
                        break;
                    }
                    else {
                        int jCount = 1, kCount = 1;
                        while(j < arr.length - 1 && arr[j] == arr[j+1]) { // 计算 arr[j] 重复多少次
                            j++;
                            jCount++;
                        }
                        while(k > 0 && arr[k] == arr[k-1]) { // 计算 arr[j] 重复多少次
                            k--;
                            kCount++;
                        }
                        result += jCount * kCount;
                        result %= MOD;
                        j++; k--;
                    }
                }
            }
        }
        return (int) result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().threeSumMulti(new int[] {1, 1, 2, 2, 3, 3, 4, 4, 5, 5}, 8));
        System.out.println(new Solution().threeSumMulti(new int[] {1, 1, 2, 2, 2, 2}, 5));
        System.out.println(new Solution().threeSumMulti(new int[] {1, 1, 1, 1, 1, 1}, 3));
    }
}