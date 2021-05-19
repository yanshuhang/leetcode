import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public List<String> solution(int n) {
        // 模拟
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            boolean b1 = (i % 3 == 0);
            boolean b2 = (i % 5 == 0);
            String s = "";
            if (b1) {
                s += "Fizz";
            }
            if (b2) {
                s += "Buzz";
            }
            if (s.equals("")) {
                s += Integer.toString(i);
            }
            list.add(s);
        }
        return list;
    }

    public List<String> solution1(int n) {
        List<String> ans = new ArrayList<>();
        ArrayList<node> list = new ArrayList<>(){
            {
                add(new node(3, "Fizz"));
                add(new node(5, "Buzz"));
            }
        };
        for (int i = 1; i <= n; i++) {
            StringBuilder s = new StringBuilder();
            for (node node : list) {
                if (i % node.num == 0) {
                    s.append(node.str);
                }
            }
            if (s.toString().equals("")) {
                s.append(i);
            }
            ans.add(s.toString());
        }
        return ans;
    }

    private static class node {
        private final int num;
        private final String str;

        public node(int num, String str) {
            this.num = num;
            this.str = str;
        }
    }
}
