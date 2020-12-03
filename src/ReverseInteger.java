public class ReverseInteger {
    public static int solution(int x) {
        int result = 0;
        while (x != 0) {
            int num = x % 10;
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE && num > 7)) {
                return 0;
            }
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE && num < -8)) {
                return 0;
            }
            result = result * 10 + num;
            x = x / 10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(-123456789));
    }
}
