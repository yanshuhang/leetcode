import java.util.HashMap;
import java.util.HashSet;

public class WordDictionary {
    // 使用hashmap和hashset
    HashMap<Integer, HashSet<String>> map;

    public WordDictionary() {
        map = new HashMap<>();
    }

    public void addWord(String word) {
        map.compute(word.length(), (var key, var set) -> {
            if (set == null) {
                set = new HashSet<>();
            }
            set.add(word);
            return set;
        });
    }

    public boolean search(String word) {
        HashSet<String> set = map.get(word.length());
        if (set == null) {
            return false;
        }
        if (set.contains(word)) {
            return true;
        }
        for (String s : set) {
            if (equal(s, word)) {
                return true;
            }
        }
        return false;
    }

    private boolean equal(String s, String word) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != word.charAt(i) && word.charAt(i) != '.') {
                return false;
            }
        }
        return true;
    }
}
