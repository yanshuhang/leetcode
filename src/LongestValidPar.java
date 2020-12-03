import java.util.LinkedList;

public class LongestValidPar {
    public static int solution(String s) {
        int maxlen = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(-1);
        char[] str = s.toCharArray();
        for (int i = 0; i < str.length; i++) {
            if (str[i] == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxlen = Math.max(maxlen, i - stack.peek());
                }
            }
        }
        return maxlen;
    }
}
