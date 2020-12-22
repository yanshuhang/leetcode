public class DistinctSubsequences {
    // 回溯
    public int solution(String s, String t) {
        if (s.length() < t.length()) {
            return 0;
        }
        return backtrack(s, t, 0, 0);
    }

    public int backtrack(String s, String t, int start, int count) {
        if (count == t.length()) {
            return 1;
        }
        int ans = 0;
        for (int i = start; i < s.length(); i++) {
            if (s.charAt(i) == t.charAt(count)) {
                ans += backtrack(s, t, i + 1, count + 1);
            }
        }
        return ans;
    }

    // 动态规划
    // 回溯的解法中:每个结果都依赖于s和t未匹配的字符的结果
    // 这里将回溯的过程直接从底向上
    public int solution1(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        int[][] dp = new int[sLen + 1][tLen + 1];
        for (int i = 0; i <= sLen; i++) {
            dp[i][tLen] = 1;
        }
        for (int i = tLen - 1; i >= 0; i--) {
            for (int j = sLen - 1; j >= 0; j--) {
                if (t.charAt(i) == s.charAt(j)) {
                    dp[j][i] = dp[j + 1][i + 1] + dp[j + 1][i];
                } else {
                    dp[j][i] = dp[j+1][i];
                }
            }
        }
        return dp[0][0];
    }
    public static void main(String[] args) {
        DistinctSubsequences o = new DistinctSubsequences();
        System.out.println(o.solution1("adbdadeecadeadeccaeaabdabdbcdabddddabcaaadbabaaedeeddeaeebcdeabcaaaeeaeeabcddcebddebeebedaecccbdcbcedbdaeaedcdebeecdaaedaacadbdccabddaddacdddc",
            "bcddceeeebecbc"));
    }
}
