import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LetterCombinations {
    String[] digitsToString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> ans = new ArrayList<>();
    public List<String> solution(String digits) {
        if (digits == null || digits.length() == 0) {
            return Collections.emptyList();
        }
        char[] digitStr = digits.toCharArray();
        StringBuilder sb = new StringBuilder();
        combine(digitStr, sb, 0);
        return ans;
    }

    public void combine(char[] digits, StringBuilder sb, int k) {
        if (k == digits.length) {
            ans.add(sb.toString());
            return;
        }
        int digit = digits[k] - '0';
        char[] chars = digitsToString[digit].toCharArray();
        for (char c : chars) {
            sb.append(c);
            combine(digits, sb, k+1);
            sb.deleteCharAt(k);
        }
    }

    public static void main(String[] args) {
        LetterCombinations combinations = new LetterCombinations();
        System.out.println(combinations.solution("23"));
    }
}
