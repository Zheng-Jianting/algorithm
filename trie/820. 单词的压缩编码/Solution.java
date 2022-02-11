import java.util.HashMap;
import java.util.Map;

class Solution {
    static class TrieNode {
        Map<Character, TrieNode> children;
        boolean isWord;

        public TrieNode() {
            children = new HashMap<>();
        }
    }

    public int minimumLengthEncoding(String[] words) {
        TrieNode root = buildTrie(words);
        int[] result = { 0 };
        dfs(root, 0, result);
        return result[0];
    }

    private void dfs(TrieNode root, int count, int[] result) {
        if(root.children.isEmpty()) {
            result[0] += count + 1;
            return;
        }
        for(TrieNode child : root.children.values()) {
            dfs(child, count + 1, result);
        }
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for(String word : words) {
            TrieNode node = root;
            for(int i = word.length() - 1; i >= 0; i--) {
                char ch = word.charAt(i);
                if(!node.children.containsKey(ch)) {
                    node.children.put(ch, new TrieNode());
                }
                node = node.children.get(ch);
            }
            node.isWord = true;
        }
        return root;
    }
}