public class UglyNumber2 {
    public int solution(int n) {
        // 丑数是在较小的丑数基础上乘以2或3或5得到的
        // 从最小的1开始，取乘以2、3、5之后的最小值，如果乘以2以记录过，则使用2*2计算
        int p1 = 1;
        int p2 = 1;
        int p3 = 1;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = dp[p1] * 2;
            int num3 = dp[p2] * 3;
            int num5 = dp[p3] * 5;
            dp[i] = Math.min(Math.min(num2, num3), num5);
            // 有可能有重复，不能使用else
            if (dp[i] == num2) {
                p1++;
            }
            if (dp[i] == num3) {
                p2++;
            }
            if (dp[i] == num5) {
                p3++;
            }
        }
        return dp[n];
    }
}
