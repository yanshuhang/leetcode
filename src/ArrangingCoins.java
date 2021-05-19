public class ArrangingCoins {
    public int solution(int n) {
        long left = 0;
        long right = n;
        while (left < right) {
            long mid = (left + right + 1) >> 1;
            long t = (1 + mid) * mid / 2;
            if (t > n) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return (int) left;
    }
}
