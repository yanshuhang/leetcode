import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappear {
    public List<Integer> solution(int[] nums) {
        int len = nums.length;
        for (int num : nums) {
            int index = (num - 1) % len;
            nums[index] += len;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (nums[i] <= len) {
                list.add(i + 1);
            }
        }
        return list;
    }
}
