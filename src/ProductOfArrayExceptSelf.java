public class ProductOfArrayExceptSelf {
    public int[] solution(int[] nums) {
        int[] ans = new int[nums.length];
        int i = 1;
        // 记录左侧的乘积
        for (int j = 0; j < nums.length; j++) {
            ans[j] = i;
            i *= nums[j];
        }
        i = 1;
        // 右侧的乘积跟记录中的左侧乘积相乘
        for (int j = nums.length - 1; j >= 0 ; j--) {
            ans[j] *= i;
            i *= nums[j];
        }
        return ans;
    }
}
