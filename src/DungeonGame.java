public class DungeonGame {
    public int solution(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        // 反向: 从右下到左上
        // dp存储的是该点到右下需要的最小血量
        int[][] dp = new int[m][n];
        // 最后一个格子需要的最小血量
        dp[m-1][n-1] = Math.max(0, -dungeon[m-1][n-1]);
        //最后一列
        for (int i = m - 2; i >= 0; i--) {
            dp[i][n-1] = Math.max(0, dp[i+1][n-1] - dungeon[i][n-1]);
        }
        // 最后一行
        for (int i = n - 2; i >= 0; i--) {
            dp[m-1][i] = Math.max(0, dp[m-1][i+1] - dungeon[m-1][i]);
        }
        // 其余数据
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = Math.max(0,Math.min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j]);
            }
        }
        return dp[0][0] + 1;
    }
}
