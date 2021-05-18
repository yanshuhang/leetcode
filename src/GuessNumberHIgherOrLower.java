import java.util.concurrent.ThreadLocalRandom;

public class GuessNumberHIgherOrLower {
    public int solution(int n) {
        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (guess(mid) == 0) {
                return mid;
            }
            if (guess(mid) == 1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    private int guess(int num) {
        int random = ThreadLocalRandom.current().nextInt(9);
        if (random < 3) {
            return 1;
        }
        if (random < 6) {
            return -1;
        }
        return 0;
    }
}
