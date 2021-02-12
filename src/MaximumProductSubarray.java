public class MaximumProductSubarray {
    public int solution(int[] nums) {
        // 暴力法
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int p = nums[i];
            ans = Math.max(ans, p);
            for (int j = i + 1; j < nums.length; j++) {
                p *= nums[j];
                ans = Math.max(ans, p);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-2,0,1};
        System.out.println(new MaximumProductSubarray().solution(nums));
    }
}
