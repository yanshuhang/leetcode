import java.util.HashSet;
import java.util.Set;

public class LongestConssecutiveSequence {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        // 去重
        for (int num : nums) {
            set.add(num);
        }
        int ans = 0;
        for (Integer i : set) {
            // 没有前面的才可能是最长的
            if (!set.contains(i - 1)) {
                int curr_len = 1;
                while (set.contains(++i)) {
                    curr_len++;
                }
                ans = Math.max(ans, curr_len);
            }
        }
        return ans;
    }
}
