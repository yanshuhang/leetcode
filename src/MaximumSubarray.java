public class MaximumSubarray {
    public int solution(int[] nums) {
        // 贪心:
        // 1.sum > 0, 加上当前num,可以更大
        // 2.sum <= 0, 加上当前num,不会更大,所以舍弃sum,重新计算
        // 每次计算sum后,取最大的sum
        int ans = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(sum, ans);
        }
        return ans;
    }

    public int solution1(int[] nums) {
        // 动态规划
        // 如果已知以i-1为结尾的最大和f(i-1), 那么以i为结尾的有两种情况:
        // 1.i连到i-1上, f(i) = f(i-1) + nums[i]
        // 2.i不连, f(i) = nums[i]
        // 两种情况取最大值
        // 一次遍历即可求得最大值
        int ans = Integer.MIN_VALUE;
        int pre = 0;
        for (int num : nums) {
            // 当前结尾的最大值
            pre = Math.max(pre + num, num);
            // 所有情况的最大值
            ans = Math.max(ans, pre);
        }
        return ans;
    }
}
