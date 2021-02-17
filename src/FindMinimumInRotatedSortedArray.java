public class FindMinimumInRotatedSortedArray {
    public int solution(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] <= nums[right]) {
                right = mid;
            } else {
                // mid比right大时肯定不是最小的,可以跳过
                left = mid + 1;
            }
        }
        return nums[left];
    }
}
