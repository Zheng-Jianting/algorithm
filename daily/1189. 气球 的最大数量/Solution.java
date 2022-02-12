import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> charToCount = new HashMap<>();
        for(char ch : text.toCharArray()) {
            if("balloon".indexOf(ch) != -1) {
                if(ch == 'l' || ch == 'o') {
                    charToCount.put(ch, charToCount.getOrDefault(ch, 0) + 1);
                }
                else {
                    charToCount.put(ch, charToCount.getOrDefault(ch, 0) + 2);
                }
            }
        }

        if(charToCount.size() != 5) {
            return 0;
        }

        int minValue = Integer.MAX_VALUE;
        for(Integer count : charToCount.values()) {
            minValue = Math.min(minValue, count);
        }
        return minValue == Integer.MAX_VALUE ? 0 : minValue / 2;
    }
}