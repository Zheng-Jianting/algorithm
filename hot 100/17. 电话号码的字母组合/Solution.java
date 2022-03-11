import java.util.LinkedList;
import java.util.List;

class Solution {
    private List<String> rst;
    private List<List<Character>> list;

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new LinkedList<>();
        }

        rst = new LinkedList<>();
        list = new LinkedList<>();
        for (char digit : digits.toCharArray()) {
            int n = Integer.parseInt(String.valueOf(digit));
            List<Character> chars = new LinkedList<>();
            if (n <= 6) {
                for (int i = 0; i < 3; i++) {
                    chars.add((char) ('a' + 3 * (n - 2) + i));
                }
            } else if (n == 7) {
                chars.add('p'); chars.add('q'); chars.add('r'); chars.add('s');
            } else if (n == 8) {
                chars.add('t'); chars.add('u'); chars.add('v');
            } else if (n == 9) {
                chars.add('w'); chars.add('x'); chars.add('y'); chars.add('z');
            }
            list.add(chars);
        }

        dfs(0, new String(""));
        return rst;
    }

    private void dfs(int i, String s) {
        if (i == list.size()) {
            rst.add(s);
        } else {
            List<Character> chars = list.get(i);
            for (char ch : chars) {
                dfs(i + 1, s + String.valueOf(ch));
            }
        }
    }
}