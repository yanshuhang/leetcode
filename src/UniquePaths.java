import java.util.Arrays;

public class UniquePaths {
    public int solution(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public int solution1(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        int[] dp = new int[n];
        Arrays.fill(dp ,1);
        // m行n列
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 旧dp[j]存储的是第j列第i-1行的值,dp[j-1]存储的是第j-1列第i行的值
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[n - 1];
    }
}
