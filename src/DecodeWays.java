public class DecodeWays {
    public int solution(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= s.length(); i++) {
            int first = s.charAt(i - 1) - '0';
            if (first != 0) {
                dp[i] += dp[i - 1];
            }
            int second = s.charAt(i - 2) - '0';
            if (second == 0 || second * 10 + first > 26) {
                continue;
            }
            dp[i] += dp[i - 2];
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(new DecodeWays().solution("2711"));
    }
}
