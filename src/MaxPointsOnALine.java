import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnALine {
    public int solutions(int[][] points) {
        if (points.length < 3) {
            return points.length;
        }
        int res = 0;
        // 遍历每个点,找到每个点对应的斜率上有多少个点
        for (int i = 0; i < points.length; i++) {
            int samePoints = 1;
            Map<String, Integer> map = new HashMap<>();
            for (int j = i + 1; j < points.length; j++) {
                int x = points[j][0] - points[i][0];
                int y = points[j][1] - points[i][1];
                if (x == 0 && y == 0) {
                    samePoints++;
                    continue;
                }
                int gdc = gdc(x, y);
                x = x / gdc;
                y = y / gdc;
                String key = x + "#" + y;
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            res = Math.max(res, map.values().stream().max(Comparator.comparingInt(a -> a)).orElse(0) + samePoints);
        }
        return res;
    }

    private int gdc(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
