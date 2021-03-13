import java.util.HashMap;

public class IsomorphicStrings {
    public boolean solution(String s, String t) {
        // 相同位置的字符在下次出现的位置一定还是相同的
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i), i + 1) != t.indexOf(t.charAt(i), i + 1)) {
                return false;
            }
        }
        return true;
    }

    public boolean solution1(String s, String t) {
        // 一个map不行, 必须使用两个map
        HashMap<Character, Character> s_map = new HashMap<>();
        HashMap<Character, Character> t_map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            char y = t.charAt(i);
            if ((s_map.containsKey(x) && s_map.get(x) != y) || (t_map.containsKey(y) && t_map.get(y) != x)) {
                return false;
            }
            s_map.put(x, y);
            t_map.put(y, x);
        }
        return true;
    }
}
