public class WildcardMatching {
    public boolean solution(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }
        for (int i = 1; i <= m; i++) {
            char cc = s.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char cp = p.charAt(j - 1);
                if (cp == '*') {
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                } else if (cp == cc || cp == '?') {
                    dp[i][j] = dp[i-1][j-1];
                }
            }
        }
        return dp[m][n];
    }

    public boolean solution1(String s, String p) {
        if (p == null || p.isEmpty()) {
            return s == null || s.isEmpty();
        }
        int i=0, j=0, istar = -1, jstar = -1,slen = s.length(), plen = p.length();
        while (i < slen) {
            // 优先单个字符匹配
            if (j < plen && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                i++;
                j++;
                // 单个字符不匹配,但j是星号,星号先匹配0个,但记录下位置
            } else if (j < plen && p.charAt(j) == '*') {
                istar = i;
                jstar = j;
                j++;
                // 单个字符不匹配,j也不是星号,退到上一个星号,星号先匹配一个字符
            } else if (istar > -1) {
                i = ++istar;
                j = jstar + 1;
                // 都不成功那就是匹配失败了
            } else {
                return false;
            }
        }
        // 如果j指向星号,j后面的必须全是星号才行
        while (j < plen && p.charAt(j) == '*') {
            j++;
        }
        return j == plen;
    }

    public static void main(String[] args) {
        new WildcardMatching().solution1("acdcb", "a*c?b");
    }
}
