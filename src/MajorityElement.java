import java.util.Arrays;

public class MajorityElement {
    public int solution(int[] nums) {
        // 排序版
        Arrays.sort(nums);
        return nums[nums.length >> 1];
    }

    public int solution1(int[] nums) {
        // 投票法
        // 两个不同的数抵消, 剩余的最后的数一定是众数, 因为众数肯定不会被抵消完
        int num = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (num == nums[i]) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    num = nums[i];
                    count = 1;
                }
            }
        }
        return num;
    }

    public int solution2(int[] nums) {
        int count = 0;
        int num = 0;
        for (int j : nums) {
            if (count == 0) {
                num = j;
                count++;
                continue;
            }
            if (num == j) {
                count++;
            } else {
                count--;
            }
        }
        return num;
    }
}
