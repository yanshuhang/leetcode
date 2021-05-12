import java.util.ArrayDeque;
import java.util.Deque;

public class BasicCalculator {
    public int solution(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        char preSign = '+';
        int num = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            // 连续的数字处理
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            // 遇到下一个符号时，处理上一个符号的计算逻辑
            // 加减：将数字入栈即可
            // 乘除: 将栈顶数字和当前数字计算后入栈
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == len - 1) {
                switch (preSign) {
                    case '+' :
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    default:
                        stack.push(stack.pop() / num);
                }
                preSign = s.charAt(i);
                num = 0;
            }
        }
        // 栈中数字只剩下简单的加法
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }
}
