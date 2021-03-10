import java.util.*;

public class RepeatedDNASequences {
    public List<String> solution(String s) {
        if (s.length() <= 10) {
            return Collections.emptyList();
        }
        HashSet<String> seen = new HashSet<>();
        HashSet<String> ans = new HashSet<>();
        // 时间主要消耗在字符串切片上
        for (int i = 0; i <= s.length() - 10; i++) {
            String temp = s.substring(i, i + 10);
            if (seen.contains(temp)) {
                ans.add(temp);
            } else {
                seen.add(temp);
            }
        }
        return new ArrayList<>(ans);
    }

    public List<String> solution1(String s) {
        // 将字符转为数字使用位操作进行字符串切片
        if (s.length() <= 10) {
            return Collections.emptyList();
        }
        // 字符与数字对应
        HashMap<Character, Integer> toInt = new HashMap<>();
        toInt.put('A', 0);
        toInt.put('C', 1);
        toInt.put('G', 2);
        toInt.put('T', 3);
        // 转为int数组
        int[] nums = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            nums[i] = toInt.get(s.charAt(i));
        }
        HashSet<Integer> seen = new HashSet<>();
        HashSet<String> ans = new HashSet<>();
        int bitmask = 0;
        for (int start = 0; start <= s.length() - 10; start++) {
            if (start != 0) {
                // 移位然后加上右侧的字符的两位
                bitmask <<= 2;
                bitmask |= nums[start + 9];
                // 然后移除最左侧的字符的两位信息
                bitmask &= ~(3 << 20);
            } else {
                // 初始化第一个窗口的bitmask
                for (int i = 0; i < 10; i++) {
                    bitmask <<= 2;
                    bitmask |= nums[i];
                }
            }
            if (seen.contains(bitmask)) {
                ans.add(s.substring(start, start + 10));
            } else {
                seen.add(bitmask);
            }
        }
        return new ArrayList<>(ans);
    }
}
