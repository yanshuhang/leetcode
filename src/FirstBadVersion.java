import java.util.concurrent.ThreadLocalRandom;

public class FirstBadVersion {
    public int solution(int n) {
        int left = 0;
        int right = n;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean isBadVersion(int n) {
        int rand = ThreadLocalRandom.current().nextInt(100);
        return n < rand;
    }
}
