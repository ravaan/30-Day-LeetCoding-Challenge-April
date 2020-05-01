class Solution {

    public int minPathSum(int[][] grid){
        int h = grid.length;
        int w = grid[0].length;
        int[][] dp = new int[h][w];
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                if(i == 0 && j == 0) dp[i][j] = grid[i][j];
                else{
                    int x = Integer.MAX_VALUE;
                    int y = x;
                    if(i!=0) x = dp[i-1][j];
                    if(j!=0) y = dp[i][j-1];
                    dp[i][j] = grid[i][j] + Math.min(x,y);
                }
            }
        }
        return dp[h-1][w-1];
    }

}