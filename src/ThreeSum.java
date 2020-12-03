import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> solution(int[] nums) {
        if (nums == null || nums.length < 3) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                return result;
            }
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int low = i + 1;
            int high = nums.length - 1;
            while (low < high) {
                int sum = -(nums[low] + nums[high]);
                if (sum == nums[i]) {
                    result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    while (low < high && nums[low] == nums[low + 1]) {
                        low ++;
                    }
                    while (low < high && nums[high] == nums[high - 1]) {
                        high--;
                    }
                }
                if (sum < nums[i]) {
                    high--;
                } else {
                    low++;
                }
            }
        }
        return result;
    }
}
