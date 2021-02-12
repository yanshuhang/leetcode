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

    public int solution1(int[] nums) {
        // 一次遍历: 维护两个变量, 已计算乘积的最大值和最小值
        // 如果当前是正数则最大值是乘以最大值, 如果是负数则是乘以最小值
        int ans = nums[0];
        int maxPre = nums[0];
        int minPre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 由于maxPre在计算后会变,所以需要记录下来用以minPre的计算
            int n = maxPre;
            maxPre = Math.max(maxPre * nums[i], Math.max(nums[i], minPre * nums[i]));
            minPre = Math.min(minPre * nums[i], Math.min(nums[i], n * nums[i]));
            ans = Math.max(ans, maxPre);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-4,-3,-2};
        System.out.println(new MaximumProductSubarray().solution1(nums));
    }
}
