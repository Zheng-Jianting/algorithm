import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new LinkedList<>();
        for (int i = left; i <= right; i++) {
            if (isSelfDividing(i))
                list.add(i);
        }
        return list;
    }

    private boolean isSelfDividing(int num) {
        int n = num;
        while (n > 0) {
            int k = n % 10;
            if (k == 0 || num % k != 0)
                return false;
            n /= 10;
        }
        return true;
    }
 }