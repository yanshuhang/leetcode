import java.util.ArrayDeque;
import java.util.Queue;

public class NumberOfIslands {
    public int solution(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int count = 0;
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    count++;
                    visited[i][j] = true;
                    Queue<Integer> queue = new ArrayDeque<>();
                    queue.offer(i * col + j);
                    while (!queue.isEmpty()) {
                        int num = queue.poll();
                        int row_index = num / col;
                        int col_index = num % col;
                        if (row_index - 1 >= 0 && grid[row_index-1][col_index] == '1' && !visited[row_index-1][col_index]) {
                            queue.offer((row_index-1)*col + col_index);
                            visited[row_index-1][col_index] = true;
                        }
                        if (row_index + 1 < row && grid[row_index+1][col_index] == '1' && !visited[row_index+1][col_index]) {
                            queue.offer((row_index+1)*col + col_index);
                            visited[row_index+1][col_index] = true;
                        }
                        if (col_index - 1 >= 0 && grid[row_index][col_index-1] == '1' && !visited[row_index][col_index-1]) {
                            queue.offer((row_index)*col + col_index-1);
                            visited[row_index][col_index-1] = true;
                        }
                        if (col_index +1 < col && grid[row_index][col_index+1] == '1' && !visited[row_index][col_index+1]) {
                            queue.offer((row_index)*col + col_index+1);
                            visited[row_index][col_index+1] = true;
                        }
                    }
                }
            }
        }
        return count;
    }

    public int solution1(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int count = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '1') {
                    count++;
                    dfs(grid, row, col);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int row, int col) {
        int nrows = grid.length;
        int ncols = grid[0].length;
        if (row < 0 || row >= nrows || col < 0 || col >= ncols || grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';
        dfs(grid, row -1, col);
        dfs(grid, row +1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);
    }
}
