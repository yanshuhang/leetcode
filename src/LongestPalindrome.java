public class LongestPalindrome {
    public static String solution(String s) {
        int[] range = new int[2];
        char[] str = s.toCharArray();
        int i = 0;
        while (i < str.length) {
            i = centerExpand(str, i, range);
            i++;
        }
        return s.substring(range[0], range[1] + 1);
    }

    private static int centerExpand(char[] str, int low, int[] range) {
        int high = low;
        while (high < str.length - 1 && str[low] == str[high + 1]) {
            high++;
        }
        int nextIndex = high;
        while (low > 0 && high < str.length - 1 && str[low - 1] == str[high + 1]) {
            low--;
            high++;
        }
        if (high - low > range[1] - range[0]) {
            range[0] = low;
            range[1] = high;
        }
        return nextIndex;
    }
}
