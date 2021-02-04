import java.util.Arrays;

public class PalindromePartitioning2 {
    public int solution(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int n = s.length();
        // 子串是否是回文
        boolean[][] dp = new boolean[n][n];
//        for (int len = 1; len <= n; len++) {
//            for (int i = 0; i <= n - len; i++) {
//                int j = i + len - 1;
//                dp[i][j] = s.charAt(i) == s.charAt(j) && (len < 3 || dp[i+1][j-1]);
//            }
//        }
        palindInfo(dp, s.toCharArray());
        System.out.println(Arrays.deepToString(dp));
        int[] min = new int[n];
        min[0] = 0;
        for (int i = 1; i < n; i++) {
            int temp = Integer.MAX_VALUE;
            for (int j = 0; j <= i; j++) {
                if (dp[j][i]) {
                    if (j == 0) {
                        temp = 0;
                        break;
                    } else {
                        temp = Math.min(temp, min[j - 1] + 1);
                    }
                }
            }
            min[i] = temp;
        }
        return min[n - 1];
    }

    public void palindInfo(boolean[][] dp, char[] s) {
//        int len = s.length;
//        for (int i = 0; i < len; i++) {
//            int left = i, right = i;
//            while (left >= 0 && right < len && s[left] == s[right]) {
//                dp[left][right] = true;
//                left--;
//                right++;
//            }
//            left = i;
//            right = i+1;
//            while (left >= 0 && right < len && s[left] == s[right]) {
//                dp[left][right] = true;
//                left--;
//                right++;
//            }
//        }
        for (int i = 0; i < s.length; i++) {
            dp[i][i] = true;
        }
        int left = 0;
        while (left < s.length - 1) {
            int right = left;
            while (right < s.length - 1 && s[left] == s[right+1]) {
                right++;
                for (int i = left; i <= right; i++) {
                    dp[i][right] = true;
                }
            }
            int temp = right + 1;
            while (left > 0 && right < s.length - 1 && s[left-1] == s[right+1]) {
                left--;
                right++;
                dp[left][right] = true;
            }
            left = temp;
        }
    }

    public static void main(String[] args) {
        System.out.println(new PalindromePartitioning2().solution("abaaa"));
    }
}
