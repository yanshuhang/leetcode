import java.util.Arrays;

public class SprialMatrix2 {
    public int[][] solution(int n) {
        int top = 0, right = n-1, bottom = n-1, left = 0;
        int totalNum = n * n;
        int num = 1;
        int[][] ans = new int[n][n];
        while (num <= totalNum) {
            for (int i = left; i <= right && num <= totalNum; i++) {
                ans[top][i] = num++;
            }
            top++;
            for (int i = top; i <= bottom && num <= totalNum; i++) {
                ans[i][right] = num++;
            }
            right--;
            for (int i = right; i >= left && num <= totalNum; i--) {
                ans[bottom][i] = num++;
            }
            bottom--;
            for (int i = bottom; i >= top && num <= totalNum; i--) {
                ans[i][left] = num++;
            }
            left++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new SprialMatrix2().solution(4)));
    }
}
