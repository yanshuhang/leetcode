import java.util.TreeSet;

public class ContainDuplicate3 {
    public boolean solution(int[] nums, int k, int t) {
        int len = nums.length;
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            Long ceiling = set.ceiling((long) num - (long) t);
            if (ceiling != null && ceiling <= (long) num + (long) t) {
                return true;
            }
            set.add((long) num);
            if (i >=
                k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }
}
