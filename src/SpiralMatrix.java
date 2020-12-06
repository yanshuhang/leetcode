import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> solution(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return Collections.emptyList();
        }
        int top = 0, right = matrix[0].length - 1;
        int left = 0, bottom = matrix.length - 1;
        ArrayList<Integer> ans = new ArrayList<>();
        int count = 0;
        int eleNum = matrix.length * matrix[0].length;
        while (count < eleNum) {
            for (int i = left; i <= right && count < eleNum; i++) {
                ans.add(matrix[top][i]);
                count++;
            }
            top++;
            for (int i = top; i <= bottom && count < eleNum; i++) {
                ans.add(matrix[i][right]);
                count++;
            }
            right--;
            for (int i = right; i >= left && count < eleNum; i--) {
                ans.add(matrix[bottom][i]);
                count++;
            }
            bottom--;
            for (int i = bottom; i >= top && count < eleNum; i--) {
                ans.add(matrix[i][left]);
                count++;
            }
            left++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3,4}, {5, 6,7,8}, {9,10,11,12}};
        System.out.println(new SpiralMatrix().solution(matrix));
    }
}
