public class NQueens2 {
    public int solution(int n) {
        boolean[] columns = new boolean[n];
        boolean[] diagonals1 = new boolean[2 * n - 1];
        boolean[] diagonals2 = new boolean[2 * n - 1];
        return backtrack(columns, diagonals1, diagonals2, n, 0);
    }

    public int backtrack(boolean[] columns, boolean[] diagonals1, boolean[] diagonals2, int n, int row) {
        if (row == n) {
            return 1;
        } else {
            int count = 0;
            for (int column = 0; column < n; column++) {
                int diagonal1 = row + column;
                int diagonal2 = n - 1 + (row - column);
                if (columns[column] || diagonals1[diagonal1] || diagonals2[diagonal2]) {
                    continue;
                }
                columns[column] = diagonals1[diagonal1] = diagonals2[diagonal2] = true;
                count += backtrack(columns, diagonals1, diagonals2, n, row + 1);
                columns[column] = diagonals1[diagonal1] = diagonals2[diagonal2] = false;
            }
            return count;
        }
    }

    public static void main(String[] args) {
        System.out.println(new NQueens2().solution(8));
    }
}
