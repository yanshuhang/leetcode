import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public boolean solution(String s, List<String> wordDict) {
        // set集合是hash比较,效率更高
        Set<String> set = new HashSet<>(wordDict);
        // dp[i]表示s.subString(0,i)是否符合条件
        boolean[] dp = new boolean[s.length() + 1];
        // 空字符串符合条件
        dp[0] = true;
        // dp[i]依赖于dp[0]到dp[i-1]的值
        // dp[j]为true 且 后面的字符在集合之中
        // j取值0到i-1, 这样就把所有的情况都判断了一遍
        // 如果中间有true,即可结束循环
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public boolean solution1(String s, List<String> wordDict) {
        // 记录下最大单词长度, 超过长度的在循环判断中跳过
        int len = s.length();
        int max_word_len = 0;
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        Set<String> set = new HashSet<>();
        for (String s1 : wordDict) {
            set.add(s1);
            max_word_len = Math.max(max_word_len, s1.length());
        }
        for (int i = 1; i <= len; i++) {
            for (int j = i - 1; j >= 0 && j >= i - max_word_len; j--) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
}
