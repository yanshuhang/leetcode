import java.util.HashMap;
import java.util.Map;
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

    // 桶：每个num可以表示为 num = (t+1)*a + b，其中0<=b<=t
    // num可以划分到id为a的桶，如果桶中已存在，则为true
    // 如果不存在，判断其相连的桶中是否有存在，有则判断其间隔是否小于等于t
    // 如果相连的也不存在，则继续下一个num的判断
    public boolean solution1(int[] nums, int k, int t) {
        int len = nums.length;
        Map<Long, Long> map = new HashMap<>();
        long w = (long) t + 1;
        for (int i = 0; i < len; i++) {
            int x = nums[i];
            long id = getId(x, w);
            if (map.containsKey(id)) {
                return true;
            }
            if (map.containsKey(id - 1) && Math.abs(x - map.get(id - 1)) < w) {
                return true;
            }
            if (map.containsKey(id + 1) && Math.abs(x - map.get(id + 1)) < w) {
                return true;
            }
            map.put(id, (long) x);
            if (i >= k) {
                map.remove(getId(( nums[i - k]), w));
            }
        }
        return false;
    }

    private long getId(long x, long w) {
        if (x >= 0) {
            return x / w;
        }
        return (x + 1) / w - 1;
    }
}
