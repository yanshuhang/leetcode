import java.util.Arrays;

public class MissingNumber {
    public int solution(int[] nums) {
        // 求和
        int sum = Arrays.stream(nums).sum();
        int n = nums.length;
        return (n * (n + 1)) / 2 - sum;
    }

    public int solution1(int[] num) {
        // 异或：可以在一群偶数个的数中找到单独的那个奇数个的数字
        int missing = num.length;
        for (int i = 0; i < num.length; i++) {
            missing ^= i ^ num[i];
        }
        return missing;
    }
}
