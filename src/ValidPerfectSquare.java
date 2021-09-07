public class ValidPerfectSquare {
    // 二分法
    public boolean solution(int num) {
        if (num < 2) {
            return true;
        }
        long left = 2;
        long right = num / 2;
        while (left <= right) {
            long mid = (left + right) >>> 1;
            long squre = mid * mid;
            if (squre == num) {
                return true;
            }
            if (squre > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
