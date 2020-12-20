public class InterleavingString {
    public boolean solution(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length(), t = s3.length();
        if (m + n != t) {
            return false;
        }
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0]= true;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                int p = i+j-1;
                if (i > 0) {
                    dp[i][j] = dp[i][j] || (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p));
                }
                if (j > 0) {
                    dp[i][j] = dp[i][j] || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p));
                }
            }
        }
        return dp[m][n];
    }

    // 滚动数组
    public boolean solution1(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length(), t = s3.length();
        if (m + n != t) {
            return false;
        }
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                int p = i + j - 1;
                if (i > 0) {
                    dp[j] = dp[j] && s1.charAt(i - 1) == s3.charAt(p);
                }
                if (j > 0) {
                    dp[j] = dp[j] || (dp[j-1] && s2.charAt(j - 1) == s3.charAt(p));
                }
            }
        }
        return dp[n];
    }
}
