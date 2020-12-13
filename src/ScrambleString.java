public class ScrambleString {
    public boolean solution(String s1, String s2) {
        // 为null或两个长度不一样时返回false
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        // 两个字符串相等返回true
        if (s1.equals(s2)) {
            return true;
        }

        // 判断两个字符串中每个字符的总数是否相等
        // 如果不等返回false
        int[] letters = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            letters[s1.charAt(i)-'a']++;
            letters[s2.charAt(i)-'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (letters[i] != 0) {
                return false;
            }
        }
        for (int i = 1; i < s1.length(); i++) {
            // 切割后比较
            if (solution(s1.substring(0, i), s2.substring(0, i)) && solution(s1.substring(i), s2.substring(i))) {
                return true;
            }
            // 切割后旋转再比较
            if (solution(s1.substring(0, i), s1.substring(s2.length() - i)) && solution(s1.substring(i), s2.substring(0, s2.length() - i))) {
                return true;
            }
        }
        return false;
    }
}
