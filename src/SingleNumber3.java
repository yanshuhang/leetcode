import java.util.HashSet;
import java.util.Set;

public class SingleNumber3 {
    public int[] solution(int[] nums) {
        // 使用map计数
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        return set.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] solution1(int[] nums) {
        // 分组异或
        int ret = 0;
        for (int num : nums) {
            ret ^= num;
        }
        int n = 1;
        while ((ret & n) == 0) {
            n <<= 1;
        }
        int a = 0, b = 0;
        for (int num : nums) {
            if ((num & n) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }
}
