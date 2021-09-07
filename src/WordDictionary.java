public class WordDictionary {
    // 使用前缀树数据结构
    private static class Trie {
        Trie[] children;
        boolean end;

        public Trie() {
            children = new Trie[26];
        }
    }
    Trie root;

    public WordDictionary() {
        root = new Trie();
    }

    public void addWord(String word) {
        Trie node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.end = true;
    }

    public boolean search(String word) {
        return searchHelp(word, root);
    }

    public boolean searchHelp(String word, Trie root) {
        Trie node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch == '.') {
                for (int j = 0; j < 26; j++) {
                    if (node.children[j] != null) {
                        if (searchHelp(word.substring(i + 1), node.children[j])) {
                            return true;
                        }
                    }
                }
                return false;
            }
            int index = ch - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return node.end;
    }
}
