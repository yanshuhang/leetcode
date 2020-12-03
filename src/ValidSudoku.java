public class ValidSudoku {
    public static boolean solution(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] colums = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int value = board[i][j] - '1';
                int boxIndex = (i / 3) + (j / 3) * 3;

                if (rows[i][value] || colums[j][value] || boxes[boxIndex][value]) {
                    return false;
                }
                rows[i][value] = true;
                colums[i][value] = true;
                boxes[i][value] = true;
            }
        }
        return true;
    }
}
