public class BitwiseAndOfNumbersRange {
    public int solution(int left, int right) {
        // 公共前缀
        int shift = 0;
        while (left != right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }
        return left << shift;
    }

    public int solution1(int left, int right) {
        while (left < right) {
            right &= right-1;
        }
        return right;
    }
}
