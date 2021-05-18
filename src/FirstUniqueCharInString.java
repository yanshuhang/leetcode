import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharInString {
    public int solution(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    public int solution1(String s) {
        int[] chars = new int[26];
        for (int i = 0, len = s.length(); i < len; i++) {
            chars[s.charAt(i) - 'a']++;
        }
        for (int i = 0, len = s.length(); i < len; i++) {
            if (chars[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
