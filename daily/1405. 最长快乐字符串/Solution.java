import java.util.Arrays;

class Solution {
    class Pair {
        char ch;
        int count;
        Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }

    public String longestDiverseString(int a, int b, int c) {
        StringBuilder result = new StringBuilder();

        Pair[] pairs = { new Pair('a', a), new Pair('b', b), new Pair('c', c) };
        Pair prev = new Pair('d', -1); // 保存 result 最后的字符及其数量
        while(true) { // 每次循环仅添加一个字符每次从数量最多的字符开始选, 添加时如果该字符用尽了, break
            Arrays.sort(pairs, (p1, p2) -> { return -(p1.count - p2.count); }); // 按字符数量升序排序
            if(pairs[0].ch == prev.ch) { // 数量最多的和 result 最后的是同一个字符
                if(prev.count == 2) { // 如果该字符在 result 最后面出现过 2 次了, 那么只能添加第二多的字符
                    if(pairs[1].count == 0) {
                        break;
                    }
                    result.append(pairs[1].ch);
                    pairs[1].count--;
                    prev.ch = pairs[1].ch; // 更新 result 最后的字符为第二多的
                    prev.count = 1;
                }
                else { // 如果出现次数小于 2, 直接添加即可
                    if(pairs[0].count == 0) {
                        break;
                    }
                    result.append(pairs[0].ch);
                    pairs[0].count--;
                    prev.count++;
                }
            }
            else { // 数量最多的和 result 最后的不是同一个字符, 则添加一个数量最多的字符即可
                if(pairs[0].count == 0) {
                    break;
                }
                result.append(pairs[0].ch);
                pairs[0].count--;
                prev.ch = pairs[0].ch; // 更新 result 最后的字符为最多的
                prev.count = 1;
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestDiverseString(1, 1, 7));
        System.out.println(new Solution().longestDiverseString(2, 2, 1));
        System.out.println(new Solution().longestDiverseString(7, 1, 0));
    }
}