public class UglyNumber {
    public boolean solution(int n) {
        // 除2 3 5 直到无法整除为止
        if (n <= 0) {
            return false;
        }
        int[] nums = {2, 3, 5};
        for (int num : nums) {
            while (n % num == 0) {
                n /= num;
            }
        }
        return n == 1;
    }
}
