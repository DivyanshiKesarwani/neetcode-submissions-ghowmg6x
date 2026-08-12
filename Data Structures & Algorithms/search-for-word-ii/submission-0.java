class Solution {

    class Node {
        Node[] children;
        String word;

        public Node() {
            children = new Node[26];
            word = null;
        }
    }

    Node root = new Node();

    public void insert(String word) {
        Node curr = root;

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }

            curr = curr.children[idx];
        }

        curr.word = word;
    }

    public List<String> findWords(char[][] board, String[] words) {

        List<String> ans = new ArrayList<>();

        // Build Trie
        for (String word : words) {
            insert(word);
        }

        // Start DFS from every board cell
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, ans);
            }
        }

        return ans;
    }

    public void dfs(char[][] board, int row, int col,
                    Node curr, List<String> ans) {

        // Out of bounds
        if (row < 0 || row >= board.length ||
            col < 0 || col >= board[0].length) {
            return;
        }

        // Already visited
        if (board[row][col] == '#') {
            return;
        }

        char ch = board[row][col];
        int idx = ch - 'a';

        // No word in Trie continues with this character
        if (curr.children[idx] == null) {
            return;
        }

        // Move in Trie
        curr = curr.children[idx];

        // Found a complete word
        if (curr.word != null) {
            ans.add(curr.word);

            // prevent duplicate answer
            curr.word = null;
        }

        // Mark visited
        board[row][col] = '#';

        // Explore 4 directions
        dfs(board, row + 1, col, curr, ans);
        dfs(board, row - 1, col, curr, ans);
        dfs(board, row, col + 1, curr, ans);
        dfs(board, row, col - 1, curr, ans);

        // Backtrack
        board[row][col] = ch;
    }
}