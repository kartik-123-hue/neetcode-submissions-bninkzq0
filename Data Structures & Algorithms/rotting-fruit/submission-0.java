class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] directions=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        Queue<int[]> q=new LinkedList<>();
        int ROW=grid.length;
        int COL=grid[0].length;
        int fresh=0;
        for(int r=0;r<ROW;r++){
            for(int c=0;c<COL;c++){
                if(grid[r][c]==1){
                    fresh++;
                }
                if(grid[r][c]==2){
                    q.add(new int[]{r,c});
                }
            }
        }

        int minutes=0;
        while(fresh>0 && !q.isEmpty()){
            int length=q.size();
            for(int i=0;i<length;i++){
                int[] curr=q.poll();
                int row=curr[0];
                int col=curr[1];
                for(int[] dir:directions){
                    int nr=row+dir[0];
                    int nc=col+dir[1];
                    if(nr<ROW && nc<COL && nr>=0 && nc>=0 && grid[nr][nc]==1){
                        grid[nr][nc]=2;
                        fresh--;
                        q.add(new int[]{nr,nc});
                    }
                }
            }
            minutes++;
        }
        return fresh==0?minutes:-1;
    }
}
