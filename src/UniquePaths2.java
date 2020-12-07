public class UniquePaths2 {
    public int solution(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }

        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[] dp = new int[m];
        dp[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int[] ints : obstacleGrid) {
            for (int j = 0; j < m; j++) {
                if (ints[j] == 1) {
                    dp[j] = 0;
                    continue;
                }
                if (j - 1 >= 0) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[m - 1];
    }
}
