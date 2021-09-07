import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainDuplicate {

    // 快排
    public boolean solution(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    // hashset
    public boolean solution1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            if (!set.add(x)) {
                return true;
            }
        }
        return false;
    }

    // 遍历
    public boolean solution2(int[] nums) {
        if (nums.length < 2) {
            return false;
        }
        int min = nums[0];
        int max = min;
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            int num = nums[i];
            if (num > max) {
                max = num;
                continue;
            }
            if (num < min) {
                min = num;
                continue;
            }
            if (num == min || num == max) {
                return true;
            }
            for (int j = 0; j < i; j++) {
                if (nums[j] == num) {
                    return true;
                }
            }
        }
        return false;
    }
}
