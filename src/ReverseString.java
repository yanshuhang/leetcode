public class ReverseString {
    public void solution(char[] s) {
        int len = s.length;
        for (int left = 0, right = len - 1; left < right; left++, right--) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
        }
    }

    // 异或交换值
    public void solution1(char[] s) {
        int len = s.length;
        for (int left = 0, right = len - 1; left < right; left++, right--) {
            s[left] ^= s[right];
            s[right] ^= s[left];
            s[left] ^= s[right];
        }
    }
}
