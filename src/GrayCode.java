import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    public List<Integer> solution(int n) {
        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = ans.size() - 1; j >= 0; j--) {
                ans.add(head + ans.get(j));
            }
            head <<= 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> list = new GrayCode().solution(3);
        for (Integer integer : list) {
            System.out.println(Integer.toBinaryString(integer));
        }
    }
}
