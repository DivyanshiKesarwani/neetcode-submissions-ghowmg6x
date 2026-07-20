class Solution {
    public boolean exist(char[][] board, String word) {

        int rows = board.length;
        int cols = board[0].length;

        // Try every cell as a starting point
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board, i, j, 0, word)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(char[][] board, int row, int col,
                       int idx, String word) {

        // Base case
        if (idx == word.length()) {
            return true;
        }

        // Out of bounds
        if (row < 0 || row >= board.length ||
            col < 0 || col >= board[0].length) {
            return false;
        }

        // Character doesn't match
        if (board[row][col] != word.charAt(idx)) {
            return false;
        }

        // Save original character
        char temp = board[row][col];

        // Mark as visited
        board[row][col] = '#';

        // Explore all 4 directions
        boolean found =
                dfs(board, row + 1, col, idx + 1, word) ||
                dfs(board, row - 1, col, idx + 1, word) ||
                dfs(board, row, col + 1, idx + 1, word) ||
                dfs(board, row, col - 1, idx + 1, word);

        // Backtrack (restore original character)
        board[row][col] = temp;

        return found;
    }
}