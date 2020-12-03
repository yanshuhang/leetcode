public class SudokuSolver {
    // 使用三个数组来记录数字是否已填入过
    private boolean[][] row = new boolean[9][10];
    private boolean[][] column= new boolean[9][10];
    private boolean[][][] block = new boolean[3][3][10];
    public void solution(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int digit = board[i][j] - '0';
                    row[i][digit] = column[j][digit] = block[i/3][j/3][digit] = true;
                }
            }
        }
        dfs(board, 0, 0);
    }

    public boolean dfs(char[][] board, int r, int c) {
        // 先遍历行再遍历列,行列都遍历完返回true
        if (c == 9) {
            c = 0;
            r++;
            if (r == 9) {
                return true;
            }
        }
        if (board[r][c] == '.') {
            // 在空处尝试填数字
            for (int i = 1; i <= 9; i++) {
                // 判断数字是否在本行\列\块中出现过,没有出现过返回true
                boolean canPut = !(row[r][i] || column[c][i] || block[r/3][c/3][i]);
                // 如果数字可以填入,则填入并修改数组的状态
                if (canPut) {
                    row[r][i] = true;
                    column[c][i] = true;
                    block[r/3][c/3][i] = true;
                    board[r][c] = (char) ('0' + i);
                    // 如果递归返回了true,说明已找到答案,取消循环return返回
                    if (dfs(board, r, c+1)) {
                        return true;
                    }
                    // 逻辑到这里说明,递归中方法填写数字失败,将已尝试过的数字状态都清除,进行下个数字的尝试
                    board[r][c] = '.';
                    row[r][i] = false;
                    column[c][i] = false;
                    block[r/3][c/3][i] = false;
                }
            }
        } else {
            return dfs(board, r, c + 1);
        }
        return false;
    }
}
