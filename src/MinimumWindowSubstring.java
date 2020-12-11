public class MinimumWindowSubstring {
    public String solution(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }

        // need存储t中每个字符的个数
        // window存储当前窗口中各个字符的个数
        int[] need = new int[128];
        int[] window = new int[128];

        // 初始化need数组
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }

        // 滑动窗口的左右索引和已匹配的字符个数count
        int left = 0, right = 0, count = 0;
        String ans = "";
        int minLen = s.length()+1;

        // 当right走完最后一个字符结束循环
        while (right < s.length()) {
            // 将窗口中的字符计数
            char c = s.charAt(right);
            window[c]++;
            // 如果是t中的字符,且窗口中该字符的数量不大于t中的数量
            // 匹配一个字符,count+1
            if (need[c] > 0 && need[c] >= window[c]) {
                count++;
            }
            // 当窗口中的字符匹配了t中所有的字符时
            // 当前的窗口长度和上次的最小值中取最小,取当前最小结果ans
            // 然后将left后移,直到窗口内的字符不能匹配t中的所有字符
            while (count == t.length()) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    ans = s.substring(left, right + 1);
                }
                c = s.charAt(left);
                if (need[c] > 0 && need[c] >= window[c]) {
                    count--;
                }
                window[c]--;
                left++;
            }
            right++;
        }
        return ans;
    }
}
