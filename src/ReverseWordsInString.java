import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseWordsInString {
    public String solution(String s) {
        // Api
        // 去除头尾的空白字符
        s = s.trim();
        // 以空白字符分割
        String[] split = s.split("\\s+");
        // 反转
        List<String> list = Arrays.asList(split);
        Collections.reverse(list);
        // 以空白字符连接
        return String.join(" ", list);
    }

    public String solution1(String s) {
        // 去除多余的空白字符,反转字符串,反转单个单词
        StringBuilder builder = trimString(s);
        reverse(builder, 0, builder.length()-1);
        reverseEachWord(builder);
        return builder.toString();
    }

    public StringBuilder trimString(String s) {
        int left = 0;
        int right = s.length() - 1;
        // 去除前后的空白字符
        while (left <= right && s.charAt(left) == ' ') {
            left++;
        }
        while (left <= right && s.charAt(right) == ' ') {
            right--;
        }
        StringBuilder sb = new StringBuilder();
        // 如果不是空白字符或者上一个不是空白字符则附加到sb
        while (left <= right) {
            char c = s.charAt(left);
            if (c != ' ') {
                sb.append(c);
            } else if (s.charAt(left -1) != ' ') {
                sb.append(c);
            }
            left++;
        }
        return sb;
    }

    public void reverse(StringBuilder sb, int left, int right) {
        while (left < right) {
            char temp = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, temp);
            left++;
            right--;
        }
    }

    public void reverseEachWord(StringBuilder sb) {
        int n = sb.length();
        int start = 0;
        int end = 0;
        while (start < n) {
            // 找到一个单词, end最后指向空白字符
            while (end < n && sb.charAt(end) != ' ') {
                end++;
            }
            // 反转该单词
            reverse(sb, start, end-1);
            // 跳过空白字符找下一个单词
            end++;
            start = end;
        }
    }
}
