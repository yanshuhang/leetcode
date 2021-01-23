import java.util.ArrayDeque;
import java.util.Deque;

public class SurroundedRegions {
    public void solution(char[][] board) {
        // 保留下来的'0'一定是跟边界上的'o'相连的
        // 从边界上的o找到相连的'o',标记后再更改
        int n = board.length;
        if (n == 0) {
            return;
        }
        int m = board[0].length;
        // 从四边深度遍历
        for (int i = 0; i < n; i++) {
            dfs(board, i, 0);
            dfs(board, i, m-1);
        }
        for (int i = 0; i < m; i++) {
            dfs(board, 0, i);
            dfs(board, n - 1, i);
        }
        // 深度遍历之后修改
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    // 深度优先遍历,递归
    public void dfs(char[][] board, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != 'O') {
            return;
        }
        board[x][y] = 'A';
        dfs(board, x + 1, y);
        dfs(board, x - 1, y);
        dfs(board, x, y + 1);
        dfs(board, x, y - 1);
    }

    // 广度优先遍历
    public void solution1(char[][] board) {
        int n = board.length;
        if (n == 0) {
            return;
        }
        int m = board[0].length;
        // 方向数组
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        Deque<int[]> queue = new ArrayDeque<>();
        // 找到四边的'o'放入队列
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') {
                queue.offer(new int[]{i, 0});
            }
            if (board[i][m - 1] == 'O') {
                queue.offer(new int[]{i, m - 1});
            }
        }
        for (int i = 0; i < m; i++) {
            if (board[0][i] == 'O') {
                queue.offer(new int[]{0, i});
            }
            if (board[n - 1][i] == 'O') {
                queue.offer(new int[]{n - 1, i});
            }
        }
        // 遍历所有的不覆盖的点,找到其相连的'o',将其加入队列
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            board[x][y] = 'A';
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i], my = y + dy[i];
                if (mx < 0 || mx >= n || my < 0 || my >= m || board[mx][my] != 'O') {
                    continue;
                }
                queue.offer(new int[]{mx, my});
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
