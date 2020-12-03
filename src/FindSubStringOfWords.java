import java.awt.image.PixelInterleavedSampleModel;
import java.sql.PseudoColumnUsage;
import java.sql.Statement;
import java.util.*;

public class FindSubStringOfWords {
    public static List<Integer> solution(String s, String[] words) {
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return Collections.emptyList();
        }

        List<Integer> ans = new ArrayList<>();
        int word_len = words[0].length();
        int all_len = word_len * words.length;

        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i < s.length() - all_len + 1; i++) {
            HashMap<String, Integer> temp = new HashMap<>();
            for (int k = i; k < i + all_len; k = k + word_len) {
                String w = s.substring(k, k + word_len);
                temp.put(w, temp.getOrDefault(w, 0) + 1);
                if (temp.getOrDefault(w, 0) > map.getOrDefault(w, 0)) {
                    break;
                }
            }
            if (map.equals(temp)) {
                ans.add(i);
            }

        }
        return ans;
    }

    public List<Integer> solution1(String s, String[] words) {
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return Collections.emptyList();
        }

        List<Integer> ans = new ArrayList<>();
        int word_len = words[0].length();
        int word_num = words.length;
        int all_len = word_len * word_num;

        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < word_len; i++) {
            int start = i;
            while (start + all_len <= s.length()) {
                Map<String, Integer> temp = new HashMap<>();
                String subStr = s.substring(start, start + all_len);
                int k = word_num;
                while (k > 0) {
                    String word = subStr.substring((k - 1) * word_len, k * word_len);
                    int count = temp.getOrDefault(word, 0) + 1;
                    if (count > map.getOrDefault(word, 0)) {
                        break;
                    }
                    temp.put(word, count);
                    --k;
                }
                if (k == 0) {
                    ans.add(start);
                }
                start = start + word_len * Math.max(k, 1);
            }
        }
        return ans;
    }

}
