class Solution {
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        if(row == 0) return 0;
        int col = matrix[0].length;
        int ans = 0;

        int dp[][] = new int[row][col];
        for(int i=0; i<row; i++) {
            dp[i][0] = matrix[i][0] - '0';
            ans = Math.max(ans, dp[i][0]);
        }
        for(int j=0; j<col; j++) {
            dp[0][j] = matrix[0][j] - '0';
            ans = Math.max(ans, dp[0][j]);
        }

        for(int i=1; i<row; i++) {
            for(int j=1; j<col; j++) {
                if((matrix[i][j] - '0') == 1) {
                    int min = Math.min(dp[i][j-1],dp[i-1][j]);
                    min = Math.min(min,dp[i-1][j-1]);
                    int temp = matrix[i][j] - '0';
                    dp[i][j] = min + temp;
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        return ans*ans;
    }
}

// 1 0 1 1 0 1
// 1 1 1 1 1 1
// 0 1 1 0 1 1
// 1 1 1 0 1 0
// 0 1 1 1 1 1
// 1 1 0 1 1 1

// 1 0 1 1 0 1
// 1 1 1 2 1 1
// 0 1 2 0 x x
// 1 x x x x x
// 0 x x x x x
// 1 x x x x x
