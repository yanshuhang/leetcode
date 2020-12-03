public class NextPermutation {
    public static void solution(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int k = nums.length - 1;
            while (k >= 0 && nums[k] <= nums[i]) {
                k--;
            }
            swap(nums, i, k);
        }
        reverse(nums, i + 1);
    }

    public static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void reverse(int[] nums, int start) {
        int left = start;
        int right = nums.length;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
