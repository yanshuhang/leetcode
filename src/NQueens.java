import java.util.*;

public class NQueens {
    public List<List<String>> solution(int n) {
        List<List<String>> ans = new ArrayList<>();
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        Set<Integer> colums = new HashSet<>();
        Set<Integer> diagonals1 = new HashSet<>();
        Set<Integer> diagonals2 = new HashSet<>();
        backtrack(ans,queens,n, 0, colums, diagonals1, diagonals2);
        return ans;
    }

    public void backtrack(List<List<String>> ans, int[] queens, int n, int row, Set<Integer> colums, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        if (row == n) {
            ans.add(generateBoard(queens));
        } else {
            for (int i = 0; i < n; i++) {
                if (colums.contains(i)) {
                    continue;
                }
                int diagonal1 = row - i;
                if (diagonals1.contains(diagonal1)) {
                    continue;
                }
                int diagonal2 = row + i;
                if (diagonals2.contains(diagonal2)) {
                    continue;
                }
                queens[row] = i;
                colums.add(i);
                diagonals1.add(diagonal1);
                diagonals2.add(diagonal2);
                backtrack(ans, queens,n, row+1, colums, diagonals1, diagonals2);
                queens[row] = -1;
                colums.remove(i);
                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);
            }
        }
    }

    public List<String> generateBoard(int[] queens) {
        List<String> board = new ArrayList<>();
        for (int queen : queens) {
            char[] row = new char[queens.length];
            Arrays.fill(row, '.');
            row[queen] = 'Q';
            board.add(new String(row));
        }
        return board;
    }

    public List<List<String>> solution1(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] chars : board) {
            Arrays.fill(chars, '.');
        }
        boolean[] colums = new boolean[n];
        boolean[] diagonals1 = new boolean[2 * n - 1];
        boolean[] diagonals2 = new boolean[2 * n - 1];
        backtrack1(ans, board, colums, diagonals1, diagonals2, n, 0);
        return ans;
    }

    public void backtrack1(List<List<String>> ans, char[][] board, boolean[] colums, boolean[] diagonals1, boolean[] diagonals2, int n, int row) {
        if (row == n) {
            List<String> list = new ArrayList<>();
            for (char[] chars : board) {
                list.add(new String(chars));
            }
            ans.add(list);
        } else {
            for (int i = 0; i < n; i++) {
                int diagonal1 = n - 1 + (row - i);
                int diagonal2 = row + i;
                if (colums[i] || diagonals1[diagonal1] || diagonals2[diagonal2]) {
                    continue;
                }
                board[i][row] = 'Q';
                colums[i] =diagonals1[diagonal1] = diagonals2[diagonal2] = true;
                backtrack1(ans, board, colums, diagonals1, diagonals2, n, row + 1);
                colums[i] = diagonals1[diagonal1] = diagonals2[diagonal2] = false;
                board[i][row] = '.';
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(new NQueens().solution(4));
        System.out.println(new NQueens().solution1(4));
    }
}
