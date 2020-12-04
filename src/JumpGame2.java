public class JumpGame2 {
    public int solution(int[] nums) {
        int index = nums.length - 1;
        int count = 0;
        while (index > 0) {
            for (int i = 0; i < index; i++) {
                if (i + nums[i] >= index) {
                    index = i;
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public int solution1(int[] nums) {
        int position = 0;
        int step = 0;
        int end = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            position = Math.max(position, i + nums[i]);
            if (i == end) {
                end = position;
                step++;
            }
        }
        return step;
    }
}
