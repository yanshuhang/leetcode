public class DivideTwoIntegers {
    public static int solution(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (divisor == 1) {
            return dividend;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean flag = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);

        dividend = -Math.abs(dividend);
        divisor = -Math.abs(divisor);
        int result = 0;
        while (dividend <= divisor) {
            int timesDivisor = divisor;
            int times = 1;
            while (dividend - timesDivisor <= timesDivisor) {
                timesDivisor += timesDivisor;
                times += times;
            }
            dividend -= timesDivisor;
            result += times;

        }
        return flag ? -result : result;
    }

    public static void main(String[] args) {
        solution(10000, 10);
    }
}
