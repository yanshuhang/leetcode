public class MyPow {
    public double solution(double x, int n) {
        if (x == 0.0) {
            return 0.0;
        }
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }
    public double quickMul(double x, long n) {
        double ans = 1.0;
        double temp = x;
        while (n > 0) {
            if (n % 2 == 1) {
                ans *= temp;
            }
            temp *= temp;
            n /= 2;
        }
        return ans;
    }
}
