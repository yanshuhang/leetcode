import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {
    public int solution(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i-1][0] + triangle.get(i).get(0);
            dp[i][i] = dp[i-1][i-1] + triangle.get(i).get(i);
        }
        for (int i = 2; i < n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return Arrays.stream(dp[n - 1]).min().orElse(0);
    }

    // 滚动数组
    public int solution1(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int n = triangle.size();
        int[] dp = new int[n];
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            List<Integer> list = triangle.get(i);
            dp[i] = list.get(i) + dp[i-1];
            for (int j = i-1; j > 0; j--) {
                dp[j] = list.get(j) + Math.min(dp[j - 1], dp[j]);
            }
            dp[0] = list.get(0) + dp[0];
        }
        return Arrays.stream(dp).min().orElse(0);
    }

    // 自底向上计算
    public int solution2(List<List<Integer>> triangle) {
//        int[] dp = triangle.get(triangle.size()-1).stream().mapToInt(Integer::intValue).toArray();
        int[] dp = new int[triangle.size()+1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(List.of(2));
        list.add(List.of(3,4));
        list.add(List.of(6,5,7));
        list.add(List.of(4,1,8,3));
        Triangle o = new Triangle();
        System.out.println(o.solution2(list));
    }
}
