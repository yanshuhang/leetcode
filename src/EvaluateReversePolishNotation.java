import java.util.ArrayDeque;
import java.util.Deque;

public class EvaluateReversePolishNotation {
    public int solution(String[] tokens) {
        // 使用栈: 遇到数字压入栈, 遇到符号弹出两个数字进行计算
        // 注意减法和除法的的数字顺序
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            if (!token.equals("+") && !token.equals("-") && !token.equals("*") && !token.equals("/")) {
                stack.push(Integer.valueOf(token));
                continue;
            }
            int n2 = stack.pop();
            int n1 = stack.pop();
            switch (token) {
                case "+":
                    stack.push(n1 + n2);
                    break;
                case "-":
                    stack.push(n1 - n2);
                    break;
                case "*":
                    stack.push(n1 * n2);
                    break;
                case  "/":
                    stack.push(n1 / n2);
                    break;
            }
        }
        return stack.pop();
    }

    public int solution1(String[] tokens) {
        // 使用数组模拟栈
        int[] stack = new int[tokens.length / 2 + 1];
        int index = 0;
        for (String token : tokens) {
            switch (token) {
                case "+":
                    stack[index-2] += stack[--index];
                    break;
                case "-":
                    stack[index-2] -= stack[--index];
                    break;
                case "*":
                    stack[index-2] *= stack[--index];
                    break;
                case "/":
                    stack[index-2] /= stack[--index];
                    break;
                default:
                    stack[index++] = Integer.parseInt(token);
            }
        }
        return stack[0];
    }
}
