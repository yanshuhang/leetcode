public class SearchInRotatedSortedArray2 {
    public boolean solution(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] == target) {
                return true;
            }
            // 数组元素有重复,所以两边的元素可以一样大
            // 当mid两边的元素一样大时,无法分辨出mid处于前半段还是后半段中
            // 将重复的去掉后,可以判断处mid处于哪半段,然后可以判断target的位置
            if (nums[left] == nums[mid]) {
                left++;
                continue;
            }
            // 数组分为前后两端有序区间
            // mid处于前半段
            if (nums[left] < nums[mid]) {
                // 如果target处于mid的左边,修改right继续找
                // 否则修改left继续找
                if (nums[mid] > target && nums[left] <= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
                // mid 处于后半段
            } else {
                // 如果target处于mid的右边,修改left继续找
                // 否则修改right继续找
                if (nums[mid] < target && nums[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}
