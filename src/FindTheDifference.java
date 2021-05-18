public class FindTheDifference {
    public char solution(String s, String t) {
        // 计数
        int[] chars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            int index = t.charAt(i) - 'a';
            if (chars[index] == 0) {
                return t.charAt(i);
            } else {
                chars[index]--;
            }
        }
        return ' ';
    }

    public char solution1(String s, String t) {
        // 求和相减
        return (char) (t.chars().sum() - s.chars().sum());
    }

    public char solution2(String s, String t) {
        // 异或去相同
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            ans ^= s.charAt(i);
        }
        for (int i = 0; i < t.length(); i++) {
            ans ^= t.charAt(i);
        }
        return (char) ans;
    }
}
