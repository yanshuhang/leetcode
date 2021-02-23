public class FindPeakElement {
    public int solution(int[] nums) {
        // 遍历: 遇到的第一个比右边的大肯定就是峰值
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return nums.length - 1;
    }

    public int solution1(int[] nums) {
        // 二分查找
        // 数组可看在是多个升序和降序的组合
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
