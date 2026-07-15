class Solution {
    int ROW;
    int COL;
    int[][] directions =new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public void solve(char[][] grid) {
         this.ROW=grid.length;
        this.COL=grid[0].length;

        for(int r=0;r<ROW;r++){
       
            if(grid[r][0]=='O'){
              
                dfs(grid,r,0);
            }
             if(grid[r][COL-1]=='O'){
                
                dfs(grid,r,COL-1);
            }
        }

        for(int c=0;c<COL;c++){
            if(grid[0][c]=='O'){
                
                dfs(grid,0,c);
            }
             if (grid[ROW-1][c]=='O'){
                dfs(grid,ROW-1,c);
            }
        }
        for(int r=0;r<ROW;r++){
            for(int c=0;c<COL;c++){
                if(grid[r][c]=='O'){
                    grid[r][c]='X';
                }
                else if(grid[r][c]=='#'){
                    grid[r][c]='O';
                }
            }
        }
    }
    public void dfs(char[][] grid,int r ,int c){
        grid[r][c]='#';
        for(int[] dir:directions){
            int nr=r+dir[0];
            int nc=c+dir[1];
            if(nr>=0 && nc>=0 && nr<ROW && nc<COL && grid[nr][nc]=='O'){
                dfs(grid,nr,nc);
            }
        }
    }
}
