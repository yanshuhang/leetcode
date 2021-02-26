public class TwoSum2 {
    public int[] solution(int[] numbers, int target) {
        // 双指针: 一前一后
        // 和大于目标: 前面的指针往后移
        // 和小于目标: 后面的指针往前移
        int left = 0;
        int right= numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left+1,right+1};
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{-1,-1};
    }
}
