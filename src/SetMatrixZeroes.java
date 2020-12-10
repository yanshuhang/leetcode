public class SetMatrixZeroes {
    public void solultion(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        boolean[] zero_row = new boolean[row];
        boolean[] zero_column = new boolean[column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == 0) {
                    zero_row[i] = true;
                    zero_column[j] = true;
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (zero_row[i] || zero_column[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public void solution1(int[][] matrix) {
        // 使用矩阵的第一行和第一列来存储相应的列与行是否置为0的信息
        // 第一行可以使用martrix[0][0]存储信息,第一列使用一个额外的变量
        int row = matrix.length;
        int column = matrix[0].length;
        boolean isCol = false;
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) {
                isCol = true;
            }
            for (int j = 1; j < column; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        // 设置除第一列第一行的矩阵
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        // 设置第一行
        if (matrix[0][0] == 0) {
            for (int i = 0; i < column; i++) {
                matrix[0][i] = 0;
            }
        }
        // 设置第一列
        if (isCol) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
