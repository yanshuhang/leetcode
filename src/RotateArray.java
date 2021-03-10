public class RotateArray {
    public void solution(int[] nums, int k) {
        // 使用额外数组
        int len = nums.length;
        int[] temp = new int[len];
        for (int i = 0; i < len; i++) {
            int index = (i+k) % len;
            temp[index] = nums[i];
        }
        System.arraycopy(temp, 0, nums, 0, len);
    }

    public void solution1(int[] nums, int k) {
        // 多次反转
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}
