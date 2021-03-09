import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RepeatedDNASequences {
    public List<String> solution(String s) {
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
}
