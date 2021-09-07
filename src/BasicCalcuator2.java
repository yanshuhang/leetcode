import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class BasicCalcuator2 {
    // 记录下每个左括号前的符号，+使用该符号，-翻转该符号，右括号弹出左括号前的符号
    // 数字依次加法
    public int solution(String s) {
        Deque<Integer> ops = new ArrayDeque<>();
        ops.push(1);
        int sign = 1;

        int ans = 0;
        int len = s.length();
        int i = 0;
        while (i < len) {
            if (s.charAt(i) == ' ') {
                i++;
            } else if (s.charAt(i) == '+') {
                sign = Objects.requireNonNull(ops.peek(), "无效的表达式");
                i++;
            } else if (s.charAt(i) == '-') {
                sign = Objects.requireNonNull(ops.peek(), "无效的表达式");
                i++;
            } else if (s.charAt(i) == '(') {
                ops.push(sign);
                i++;
            } else if (s.charAt(i) == ')') {
                ops.pop();
                i++;
            } else {
                int num = 0;
                // 连续数字
                while (i < len && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                ans += sign * num;
            }
        }
        return ans;
    }
}
