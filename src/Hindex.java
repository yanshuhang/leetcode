import java.util.Arrays;

public class Hindex {
    public int solution(int[] citations) {
        // 排序，倒序，如果索引大于值则不满足条件
        Arrays.sort(citations);
        int i = 0;
        while (i < citations.length && citations[citations.length - 1 - i] > i) {
            i++;
        }
        return i;
    }

    public int solution1(int[] citations) {
        // 计数
        int n = citations.length;
        int[] counts = new int[n + 1];
        for (int num : citations) {
            counts[Math.min(n, num)]++;
        }
        int k = n;
        for (int s = counts[n]; k > s; s += counts[k]) {
            k--;
        }
        return k;
    }
}
