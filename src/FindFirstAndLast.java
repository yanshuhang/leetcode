public class FindFirstAndLast {
    public static int[] solution(int[] nums, int target) {
        int left = findBound(nums, target, true);
        int right = findBound(nums, target, false);
        return new int[]{left, right};
    }
    private static int findBound(int[] nums, int target, boolean b) {
        int left = 0;
        int right = nums.length - 1;
        int res = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (b) {
                res = mid;
                right = mid - 1;
            } else {
                res = mid;
                left = mid + 1;
            }

        }
        return res;
    }
}
