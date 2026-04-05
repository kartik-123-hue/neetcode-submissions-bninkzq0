class Solution {
    int ROW,COL;
    int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
    public int numIslands(char[][] grid) {
        int island=0;
        ROW=grid.length;
        COL=grid[0].length;
        for(int r=0;r<ROW;r++){
            for(int c=0;c<COL;c++){
                if(grid[r][c]=='1'){
                    dfs(r,c,grid);
                    island++;
                }
            }
        }
        return island;
    }
    public void dfs(int r,int c,char[][] grid){
        grid[r][c]='0';
        for(int[] dir:dirs){
            int nr=r+dir[0];
            int nc=c+dir[1];
            if(nr>=0 && nr< ROW && nc>=0 && nc<COL && grid[nr][nc]=='1'){
                dfs(nr,nc,grid);
            }
        }
    }
}
