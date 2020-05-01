class Solution {
    public boolean inside(int h, int w, int x, int y){
        if(x >= 0 && x < h && y >=0 && y < w) return true;
        return false;
    }
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int h = grid.length;
        int w = grid[0].length;
        boolean[][] vis = new boolean[h][w];
        ArrayList<cord> move = new ArrayList<>(){{
            add(new cord(1, 0));
            add(new cord(-1, 0));
            add(new cord(0, 1));
            add(new cord(0, -1));
        }};
        int answer = 0;
        for(int i=0; i<h; i++){
            for( int j=0; j< w; j++){
                if(!vis[i][j] && grid[i][j] == '1'){
                    answer++;
                    Queue<cord> q = new LinkedList<>();
                    q.add(new cord(i, j));
                    vis[i][j] = true;
                    while(q.size() != 0){
                        cord temp = q.poll();
                        int x = temp.x;
                        int y = temp.y;
                        for(cord cor: move){
                            int nx = x + cor.x;
                            int ny = y + cor.y;
                            if(inside(h, w, nx, ny) && !vis[nx][ny] && grid[nx][ny] == '1'){
                                q.add(new cord(nx, ny));
                                vis[nx][ny] = true;
                            }
                        }
                    }

                }
            }
        }
        return answer;
    }
}

class cord{
    int x;
    int y;
    public cord(int x, int y){
        this.x = x;
        this.y = y;
    }
}