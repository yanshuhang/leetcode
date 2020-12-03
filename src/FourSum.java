import com.sun.tools.javac.Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FourSum {
    public static List<List<Integer>> solution(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int min_i = nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3];
            if (target < min_i) {
                break;
            }
            // 当前的最大值比target还打，继续循环是有可能找到，continue
            int max_i = nums[i] + nums[len - 1] + nums[len - 2] + nums[len - 3];
            if (target > max_i) {
                continue;
            }
            for (int k = i+1; k < len - 2; k++) {
                if (k > i + 1 && nums[k] == nums[k - 1]) {
                    continue;
                }
                int min_k = nums[i] + nums[k] + nums[k + 1] + nums[k + 2];
                if (target < min_k) {
                    break;
                }
                int max_k = nums[i] + nums[k] + nums[len - 1] + nums[len - 2];
                if (target > max_k) {
                    continue;
                }
                int lo = k+1;
                int hi = len - 1;
                while (lo < hi) {
                    int sum = nums[i] + nums[k] + nums[lo] + nums[hi];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[k], nums[lo], nums[hi]));
                        lo++;
                        hi--;
                        while (lo < hi && nums[lo] == nums[lo - 1]) {
                            lo++;
                        }
                        while (lo < hi && nums[hi] == nums[hi + 1]) {
                            hi--;
                        }
                    } else if (sum < target) {
                        lo++;
                    } else {
                        hi--;
                    }
                }
            }
        }
        return result;

    }

    public static void main(String[] args) {
        int[] nums = {-2,-1,-1,1,1,2,2};
        System.out.println(solution(nums, 0));
    }
}
