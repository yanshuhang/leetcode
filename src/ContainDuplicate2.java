import java.util.HashSet;
import java.util.Set;

public class ContainDuplicate2 {
    // hashset
    public boolean solution(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return true;
            }
            if (i >= k) {
                set.remove((nums[i - k]));
            }
        }
        return false;
    }

    // 遍历
    public boolean solution1(int[] nums, int k) {
        int len = nums.length;
        if (len < 2) {
            return false;
        }
        int max;
        int min;
        max = min = nums[0];
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            if (num > max) {
                max = num;
                continue;
            }
            if (num < min) {
                min = num;
                continue;
            }
            for (int j = Math.max(0, i - k); j < i; j++) {
                if (nums[j] == num) {
                    return true;
                }
            }
        }
        return false;
    }
}
