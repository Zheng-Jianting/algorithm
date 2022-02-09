import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<String> simplifiedFractions(int n) { // 暴力
        List<String> result = new LinkedList<>();
        int a, b; // 分母, 分子
        for(a = 2; a <= n; a++) {
            for(b = 1; b < a; b++) {
                if(isSamplest(a, b)) {
                    result.add(String.valueOf(b) + "/" + String.valueOf(a));
                }
            }
        }
        return result;
    }

    private boolean isSamplest(int a, int b) {
        while(b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a == 1 ? true : false;
    }
}