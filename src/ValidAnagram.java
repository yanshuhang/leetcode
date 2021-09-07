import java.util.Arrays;
import java.util.HashMap;

public class ValidAnagram {
    // 排序后比较数组
    public boolean solution(String s, String t) {
        if (s.length() != t.length())
            return false;
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        return Arrays.equals(sChars, tChars);
    }

    // 计算各个字符出现的次数是否相同，全小写字符，使用数组
    public boolean solution1(String s, String t) {
        int len = s.length();
        if (len != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < len; i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < len; i++) {
            int index = t.charAt(i) - 'a';
            table[index]--;
            // 小于0 说明比s中的同字符数量多
            if (table[index] < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean solution2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) - 1);
            if (map.get(ch) < 0) {
                return false;
            }
        }
        return true;
    }
}
