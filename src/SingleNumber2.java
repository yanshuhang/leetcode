import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SingleNumber2 {
    public int solution(int[] nums) {
        // 使用hashset进行去重
        Set<Integer> set = new HashSet<>();
        long set_sum = 0;
        long arr_sum = 0;
        for (int num : nums) {
            arr_sum += num;
            set.add(num);
        }
        for (Integer integer : set) {
            set_sum += integer;
        }
        return (int) ((3 * set_sum - arr_sum) / 2);
    }

    public int solution1(int[] nums) {
        // 使用map对数字计数
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }
        }
        return -1;
    }

    public int solution2(int[] nums) {
        // 统计所有数字中每个位出现1的次数总和, 总和必为3的倍数或3的倍数+1
        // 这样可以确定单个的那个数在该位是0还是1
        // 虽然没有使用多余的空间,但对于每个位都遍历了一遍数组
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int num : nums) {
                sum += (num >> i) & 1;
            }
            ans ^= (sum % 3) << i;
//            ans += (sum % 3) << i;
        }
        return ans;
    }

    public int solution3(int[] nums) {
        // 某位出现1的总和除以3的余数为0或1或2,
        // 最后该位是0或1 取决于单独的那个数
        int ones = 0;
        int twos = 0;
        for (int num : nums) {
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }
}
