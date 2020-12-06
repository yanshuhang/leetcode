import java.util.Arrays;

public class PermutationSequence {
    public String solution(int n, int k) {
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
        StringBuilder builder = new StringBuilder();
        int[] used = new int[n + 1];
        Arrays.fill(used, 1);
        --k;
        for (int i = 1; i <= n; i++) {
            int order = k / factorial[n - i] + 1;
            for (int j = 1; j <= n; j++) {
                order -= used[j];
                if (order == 0) {
                    builder.append(j);
                    used[j] = 0;
                    break;
                }
            }
            k %= factorial[n-i];
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new PermutationSequence().solution(5,15));
    }
}
