import java.util.LinkedList;

public class ValidPar {
    public static boolean solution(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        char[] stack = new char[s.length()];
        int top = 0;

        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
//            if (x == ')') {
//                if (top == 0) {
//                    return false;
//                }
//                if (stack[top - 1] == '(') {
//                    top--;
//                    continue;
//                }
//                return false;
//            }
//            if (x == '}') {
//                if (top == 0) {
//                    return false;
//                }
//                if (stack[top - 1] == '{') {
//                    top--;
//                    continue;
//                }
//                return false;
//            }
//            if (x == ']') {
//                if (top == 0) {
//                    return false;
//                }
//                if (stack[top - 1] == '[') {
//                    top--;
//                    continue;
//                }
//                return false;
//            }
//            stack[top++] = x;
            switch (x) {
                case '(':
                    stack[top++] = ')';
                    break;
                case '{':
                    stack[top++] = '}';
                    break;
                case '[':
                    stack[top++] = ']';
                    break;
                default:
                    if (top == 0) {
                        return false;
                    }
                    if (stack[--top] != x) {
                        return false;
                    }
            }
        }
        return top == 0;
    }

    public static void main(String[] args) {
        solution("()");
    }
}
