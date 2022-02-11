import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class MagicDictionary {
    static class TrieNode {
        Map<Character, TrieNode> children;
        boolean isWord;

        TrieNode() {
            children = new HashMap<>();
        }
    }

    private TrieNode root;

    public MagicDictionary() {
        root = new TrieNode();
    }
    
    public void buildDict(String[] dictionary) {
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
    }
    
    public boolean search(String searchWord) {
        return dfs(root, searchWord, 0, 0);
    }

    private boolean dfs(TrieNode root, String word, int i, int count) {
        if(root.isWord && i == word.length() && count == 1) {
            return true;
        }
        if(i < word.length() && count <= 1) {
            boolean isFound = false;
            Iterator<Map.Entry<Character, TrieNode>> entries = root.children.entrySet().iterator();
            while(entries.hasNext() && !isFound) {
                Map.Entry<Character, TrieNode> entry = entries.next();
                int next = entry.getKey() == word.charAt(i) ? count : count + 1; // 注意不要修改 count
                isFound = dfs(entry.getValue(), word, i + 1, next);
            }
            return isFound;
        }
        return false;
    }

    public static void main(String[] args) {
        MagicDictionary magicDictionary = new MagicDictionary();
        magicDictionary.buildDict(new String[] { "leetcode" });
        System.out.println(magicDictionary.search("leetcode"));
    }
}