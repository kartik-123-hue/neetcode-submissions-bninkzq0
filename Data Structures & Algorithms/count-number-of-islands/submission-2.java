class Solution {
    int[][] dir=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    int ROW;
    int COL;
    public int numIslands(char[][] grid) {
        this.ROW=grid.length;
        this.COL=grid[0].length;
        int islands=0;
        for(int r=0;r<ROW;r++){
            for(int c=0;c<COL;c++){
                if(grid[r][c]=='1'){
                    dfs(grid,r,c);
                    islands++;
                }
            }
        }
        return islands;
    }
    public void dfs(char[][] grid,int r,int c)
    {
        // if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c]==0){
        //     return;
        // }
        grid[r][c]=0;
        for(int[] d:dir){
            int nr=r+d[0];
            int nc=c+d[1];
            if(nr>=0 && nc>=0 && nr<ROW && nc<COL &&   grid[nr][nc]=='1'){
                dfs(grid,nr,nc);
            }
        }
    }
}
