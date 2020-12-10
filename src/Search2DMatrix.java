public class Search2DMatrix {
    public boolean solution(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int left = 0;
        int right = row * column - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            int val = matrix[mid / column][mid % column];
            if (val == target) {
                return true;
            }
            if (val > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
