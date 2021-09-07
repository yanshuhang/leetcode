public class PowerOfThree {
    // 循环
    public boolean solution(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    // 数学
    public boolean solution1(int n) {
        return n > 0 && 1162261467 % n == 0;
    }

}
