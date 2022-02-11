import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    static class TrieNode {
        Map<Character, TrieNode> children;
        boolean isWord;

        public TrieNode() {
            children = new HashMap<>();
            isWord = false;
        }
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = buildTrie(dictionary);
        String[] words = sentence.split(" ");
        for(int k = 0; k < words.length; k++) {
            int[] i = { 0 };
            if(dfs(root, words[k], i)) {
                words[k] = words[k].substring(0, i[0]);
            }
        }
        return String.join(" ", words);
    }

    private TrieNode buildTrie(List<String> dictionary) {
        TrieNode root = new TrieNode();
        for(String word : dictionary) {
            TrieNode node = root;
            for(char ch : word.toCharArray()) {
                if(!node.children.containsKey(ch)) {
                    node.children.put(ch, new TrieNode());
                }
                node = node.children.get(ch);
            }
            node.isWord = true;
        }
        return root;
    }

    private boolean dfs(TrieNode root, String word, int[] i) {
        if(root.isWord) {
            return true;
        }
        if(i[0] == word.length() || !root.children.containsKey(word.charAt(i[0]))) {
            return false;
        }
        char ch = word.charAt(i[0]);
        i[0]++;
        return dfs(root.children.get(ch), word, i);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().replaceWords(Arrays.asList("cat", "bat", "rat"), "the cattle was rattled by the battery"));
    }
}