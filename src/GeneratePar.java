import java.util.ArrayList;
import java.util.List;

public class GeneratePar {
    public static List<String> solution(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        dfs(ans, builder, n, n);
        return ans;
    }

    public static void dfs(List<String> ans, StringBuilder builder, int left, int right) {
        if (left == 0 && right == 0) {
            ans.add(builder.toString());
            return;
        }
        if (left > 0) {
            dfs(ans, builder.append('('), left - 1, right);
            // 方法返回后，剪掉当前加入的分支
            builder.deleteCharAt(builder.length()-1);
        }
        if (right > left) {
            dfs(ans, builder.append(')'), left, right - 1);
            // 方法返回后，剪掉当前加入的分支
            builder.deleteCharAt(builder.length()-1);
        }
    }

    public static void main(String[] args) {
        for (int i = 2; i < 5; i++) {
            System.out.println(solution(i));
        }
    }
}
