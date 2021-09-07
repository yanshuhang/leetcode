public class ReverseVowelsSting {
    public String solution(String s) {
        int len = s.length();
        int left = 0;
        int right = len - 1;
        char[] chars = s.toCharArray();
        while (left < right) {
            // 使用while循环找到下一个元音字符
            while (left < right && !isVowel(chars[left])) {
                left++;
            }
            while (left < right && !isVowel(chars[right])) {
                right--;
            }
            char c = chars[left];
            chars[left++] = chars[right];
            chars[right--] = c;
        }
        return new String(chars);
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'o' || c == 'e' || c == 'i' || c == 'u' || c == 'A' ||
            c == 'O' || c == 'E' || c == 'I' || c == 'U';
    }
}
