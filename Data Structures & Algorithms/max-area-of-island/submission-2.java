class Solution {
    int[][] directions=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    int ROW;
    int COL;
    public int maxAreaOfIsland(int[][] grid) {
        this.ROW=grid.length;
        this.COL=grid[0].length;
        int maxLandCovered=0;
        for(int r=0;r<ROW;r++){
            for(int c=0;c<COL;c++){
                if(grid[r][c]==1){
                    int[] max=new int[]{1};
                    dfs(grid,r,c,max);
                    System.out.println(Arrays.toString(max));
                    maxLandCovered=Math.max(maxLandCovered,max[0]);
                }
            }
        }
        return maxLandCovered;
    }
    public void dfs(int[][] grid,int r,int c,int[] max){
        if(r<0 || c<0 || r>=ROW || c>=COL || grid[r][c]==0){
            return;
        }
        grid[r][c]=0;
        for(int[] dir:directions){
            int nr=r+dir[0];
            int nc=c+dir[1];
            if(nr>=0 && nc>=0 && nr<ROW && nc<COL && grid[nr][nc]==1){
                max[0]+=1;
                dfs(grid,nr,nc,max);
            }
            
        }
    }
}
