import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SummaryRanges {
    public List<String> solution(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }
        int min = nums[0];
        int max = nums[0];
        List<String> answer = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num == max + 1) {
                max = num;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(min);
                if (min != max) {
                    sb.append("->");
                    sb.append(max);
                }
                answer.add(sb.toString());
                min = max = num;
            }
        }
        if (min == max) {
            answer.add(String.valueOf(min));
        } else {
            answer.add(min + "->" + max);
        }
        return answer;
    }
}
