public class StringToInteger {
    public static int solution(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int result = 0;
        int flag = 1;
        int i = 0;
        int len = s.length();
        while (i < len && s.charAt(i) == ' ') {
            i++;
        }
        char c;
        if (i < len && ((c = s.charAt(i)) == '-' || c == '+')) {
            i++;
            if (c == '-') {
                flag = -1;
            }
        }
        while (i < len && (c = s.charAt(i++)) >= '0' && c <= '9') {
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && c > '7')) {
                return flag == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            result = result * 10 + c - '0';
        }
        return result * flag;
    }

    public static void main(String[] args) {
        System.out.println(solution("-111111"));
    }
}
