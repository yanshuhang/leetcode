public class RotateImage {
    public void solution(int[][] matrix) {
        int len = matrix.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i+1; j < len; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < len; i++) {
            int left = 0;
            int right = len - 1;
            while (left < right) {
                int temp = matrix[i][right];
                matrix[i][right] = matrix[i][left];
                matrix[i][left] = temp;
                left++;
                right--;
            }
        }
    }
}
