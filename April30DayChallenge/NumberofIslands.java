class Solution {
    int row, col;
    char[][] grid;

    public int numIslands(char[][] grid) {
        row = grid.length;
        if (row == 0) return 0;
        col = grid[0].length;
        this.grid = grid;

        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    dfs(i, j);
                }
            }
        }
        return ans;
    }

    public void dfs(int i, int j) {
        if (grid[i][j] == '0') return;

        grid[i][j] = '0';

        if (i < row - 1) dfs(i + 1, j);
        if (i > 0) dfs(i - 1, j);
        if (j < col - 1) dfs(i, j + 1);
        if (j > 0) dfs(i, j - 1);
    }
}