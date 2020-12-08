public class MySqurt {
    public int solution(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int left = 0;
        int right = x;
        int ans = -1;
        while (left <= right) {
            // 求中位数的最正确的方法(left+right) >>> 1
            int mid = (left + right + 1) >>> 1;
            if ((long) mid * mid <= x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
