public class WordSearch {
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public boolean solution(char[][] board, String word) {
        int h = board.length, w = board[0].length;
        boolean[][] visited = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (backtrack(board, word, visited, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backtrack(char[][] board, String word, boolean[][] visited, int i, int j, int k) {
        if (board[i][j] != word.charAt(k)) {
            return false;
        }
        if (k == word.length() - 1) {
            return true;
        }
        if (board[i][j] == word.charAt(k)) {
            visited[i][j] = true;
            for (int[] dir : directions) {
                int ni = i + dir[0], nj = j + dir[1];
                if (ni >= 0 && ni < board.length && nj >= 0 && nj < board[0].length) {
                    if (!visited[ni][nj]) {
                        if (backtrack(board, word, visited, ni, nj, k + 1)) {
                            return true;
                        }
                    }
                }
            }
            visited[i][j] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'a', 'b', 'c', 'e'}, {'s', 'f', 'c', 's'}, {'a', 'd', 'e', 'e'}};
        String word = "abcb";
        System.out.println(new WordSearch().solution(board, word));
    }
}
