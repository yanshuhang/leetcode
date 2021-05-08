public class MaximalSquare {
    // 暴力法
    public int solution(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int maxSide = 0;
        int rows = matrix.length;
        int colums = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colums; j++) {
                if (matrix[i][j] == '1') {
                    maxSide = Math.max(maxSide, 1);
                    int currentMaxSide = Math.min(rows - i - 1, colums - j - 1);
                    for (int k = 1; k <= currentMaxSide; k++) {
                        boolean flag = true;
                        for (int m = 0; m <= k; m++) {
                            if (matrix[i + k][j + m] == '0' || matrix[i + m][j + k] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        if (flag) {
                            maxSide = Math.max(maxSide, k + 1);
                        } else {
                            break;
                        }
                    }
                }

            }
        }
        return maxSide * maxSide;
    }

    // 动态规划：以当前点为右下角的正方形
    public int solution1(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int rows = matrix.length;
        int colums = matrix[0].length;
        int[][] dp = new int[rows + 1][colums + 1];
        int maxSide = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colums; j++) {
                if (matrix[i][j] == '1') {
                    dp[i + 1][j + 1] = Math.min(Math.min(dp[i + 1][j], dp[i][j + 1]), dp[i][j]) + 1;
                }
                maxSide = Math.max(maxSide, dp[i + 1][j + 1]);
            }
        }
        return maxSide * maxSide;
    }

    // 动态规划：滚动数组版
    public int solution2(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int colums = matrix[0].length;
        int[] dp = new int[colums+1];
        int maxSide = 0;
        for (char[] row : matrix) {
            int northwest = 0;
            for (int j = 0; j < colums; j++) {
                int nextNorthwest = dp[j + 1];
                if (row[j] == '1') {
                    dp[j + 1] = Math.min(northwest, Math.min(dp[j], dp[j + 1])) + 1;
                    maxSide = Math.max(maxSide, dp[j + 1]);
                } else {
                    dp[j+1] = 0;
                }
                northwest = nextNorthwest;
            }
        }
        return maxSide * maxSide;
    }
}
