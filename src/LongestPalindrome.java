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

    // 动态规划
    public String solution1(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        for (int len = 0; len < n; len++) {
            for (int i = 0; i + len < n; i++) {
                int j = i + len;
                if (len == 0) {
                    dp[i][j] = true;
                } else {
                    boolean b = s.charAt(i) == s.charAt(j);
                    if (len == 1) {
                        dp[i][j] = b;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1] && b;
                    }
                }
                if (dp[i][j] && (len + 1 > ans.length())) {
                    ans = s.substring(i, j + 1);
                }
            }
        }
        return ans;
    }
}
