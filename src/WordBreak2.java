import java.sql.SQLOutput;
import java.util.*;

public class WordBreak2 {
    public List<String> solution(String s, List<String> wordDict) {
        // 存储以integer开头的部分可组成的句子所有可能
        Map<Integer, List<List<String>>> map = new HashMap<>();
        List<List<String>> wordBreaks = backtrack(s, new HashSet<>(wordDict), 0, map);
        List<String> ans = new ArrayList<>();
        for (List<String> wordBreak : wordBreaks) {
            ans.add(String.join(" ", wordBreak));
        }
        return ans;
    }

    public List<List<String>> backtrack(String s, Set<String> wordSet, int index, Map<Integer, List<List<String>>> map) {
        if (!map.containsKey(index)) {
            List<List<String>> wordBreaks = new ArrayList<>();
            if (index == s.length()) {
                // 到达底部时创建list用于存储单词
                // 在回溯时把单词添加到list中
                wordBreaks.add(new LinkedList<>());
            }
            for (int i = index + 1; i <= s.length(); i++) {
                String word = s.substring(index, i);
                if (wordSet.contains(word)) {
                    List<List<String>> nextWordBreaks = backtrack(s, wordSet, i, map);
                    for (List<String> nextWordBreak : nextWordBreaks) {
                        // 每个index对应的list需要时各自独立的
                        LinkedList<String> wordBreak = new LinkedList<>(nextWordBreak);
                        wordBreak.offerFirst(word);
                        wordBreaks.add(wordBreak);
                    }
                }
            }
            map.put(index, wordBreaks);
        }
        return map.get(index);
    }
}
