public class RegualrExpressionMatching {
    public static boolean solution(String s, String p) {
        int slen = s.length();
        int plen = p.length();
        boolean[][] dp = new boolean[slen + 1][plen+ 1];
        char[] schar = s.toCharArray();
        char[] pchar = p.toCharArray();
        dp[slen][plen] = true;
        for (int i = slen; i >= 0; i--) {
            for (int k = plen - 1; k >= 0; k--) {
                boolean firstMatch = i < slen && (schar[i] == pchar[k] || pchar[k] == '.');
                if (k + 1 < plen && pchar[k + 1] == '*') {
                    dp[i][k] = dp[i][k + 2] || (firstMatch && dp[i + 1][k]);
                } else {
                    dp[i][k] = firstMatch && dp[i + 1][k + 1];
                }
            }
        }
        return dp[0][0];
    }
}
