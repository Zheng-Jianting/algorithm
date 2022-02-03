import java.util.ArrayList;
import java.util.List;

class Solution {
    public int findMinFibonacciNumbers(int k) {
        List<Integer> fb = new ArrayList<Integer>();
        fb.add(1);
        fb.add(2);
        while(fb.get(fb.size() - 1) + fb.get(fb.size() - 2) <= 1e9) {
            fb.add(fb.get(fb.size() - 1) + fb.get(fb.size() - 2));
        }

        int result = 0;
        for(int i = fb.size() - 1; k > 0; i--) {
            result += k / fb.get(i);
            k %= fb.get(i);
        }

        return result;
    }
}