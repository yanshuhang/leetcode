public class IsSubsequence {
    public boolean solution(String s, String t) {
        // 双指针：找到s中字符在t中第一次出现
        int sLen = s.length();
        int tLen = t.length();
        int i = 0;
        int j = 0;
        while (i < sLen && j < tLen) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == sLen;
    }

    public boolean solution1(String s, String t) {
        // 动态规划：首先确定t的动态数组，某个索引之后字符第一次出现的位置
        int sLen = s.length();
        int tLen = t.length();
        int[][] dp = new int[tLen + 1][26];
        for (int i = 0; i < 26; i++) {
            dp[tLen][i] = -1;
        }
        for (int i = tLen - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (t.charAt(i) == j + 'a') {
                    dp[i][j] = i;
                } else {
                    dp[i][j] = dp[i+1][j];
                }
            }
        }
        int next = 0;
        for (int i = 0; i < sLen; i++) {
            if (dp[next][s.charAt(i) - 'a'] == -1) {
                return false;
            }
            next = dp[next][s.charAt(i) - 'a'] + 1;
        }
        return true;
    }
}
