import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {
    public List<String> solution(int turnedOn) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (count1(i) + count1(j) == turnedOn) {
                    ans.add(i + ":" + (j < 10 ? "0" + j : j));
                }
            }
        }
        return ans;
    }

    private int count1(int n) {
        int count = 0;
        while (n != 0) {
            // 消除最右侧的1
            n = n & (n-1);
            count++;
        }
        return count;
    }
}
