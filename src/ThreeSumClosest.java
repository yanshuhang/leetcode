import java.util.Arrays;

public class ThreeSumClosest {
    public static int solution(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                int diff = Math.abs(result - target);
                int min = nums[i] + nums[left] + nums[left + 1];
                if (target < min) {
                    if (Math.abs(min - target) < diff) {
                        result = min;
                    }
                    break;
                }
                int max = nums[i] + nums[right] + nums[right - 1];
                if (target > max) {
                    if (Math.abs(max - target) < diff) {
                        result = max;
                    }
                    break;
                }
                int sum = nums[i] + nums[right] + nums[left];
                if (sum == target) {
                    return sum;
                }
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
                if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, -1, -1, 3};
        System.out.println(solution(arr, 3));

    }
}
