import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TextJusttification {
    public List<String> solution(String[] words, int maxWidth) {
        if (words == null || words.length == 0) {
            return Collections.emptyList();
        }
        ArrayList<String> ans = new ArrayList<>();
        int start = 0, end = 0, sum = 0;
        for (String word : words) {
            int wlen = word.length();
            if (sum + wlen > maxWidth) {
                int interval_num = end - 1 - start;
                int spaces_num = maxWidth - sum + 1;
                int n = interval_num == 0 ? spaces_num : spaces_num / interval_num;
                int m = interval_num == 0 ? 0 : spaces_num % interval_num;
                StringBuilder builder = new StringBuilder();
                for (int j = start; j < end; j++) {
                    builder.append(words[j]);
                    if (j + 1 != end) {
                        builder.append(" ".repeat(Math.max(0, n + 1)));
                        if (m > 0) {
                            builder.append(" ");
                            m--;
                        }
                    }
                }
                if (interval_num == 0) {
                    builder.append(" ".repeat(spaces_num));
                }
                ans.add(builder.toString());
                sum = 0;
                start = end;
            }
            sum += wlen + 1;
            end++;
            if (end == words.length) {
                StringBuilder builder = new StringBuilder();
                for (int j = start; j < end; j++) {
                    builder.append(words[j]);
                    if (j + 1 != end) {
                        builder.append(" ");
                    }
                }
                builder.append(" ".repeat(maxWidth - sum + 1));
                ans.add(builder.toString());
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] words = {"What","must","be","acknowledgment","shall","sssssssss"
        };
        int maxWidth = 16;
        List<String> list = new TextJusttification().solution(words, maxWidth);
        for (String s : list) {
            System.out.printf("\"%s\"%n", s);
        }
    }
}
