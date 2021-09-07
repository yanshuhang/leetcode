public class LongthPalindrome {
    public int solution(String s) {
        int[] count = new int[128];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }
        int n = 0;
        for (int i : count) {
            // 找出奇数的字符有多少个
            n += i % 2;
        }
        return n == 0 ? s.length() : s.length() - n + 1;
    }
}
