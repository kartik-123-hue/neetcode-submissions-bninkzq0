class Solution {
    boolean[][] visited;
    int[][] directions =new int[][] {{0,1},{0,-1},{-1,0},{1,0}};
    int ROW;
    int COL;
    int INF=2147483647;
    public void islandsAndTreasure(int[][] grid) {
        this.ROW=grid.length;
        this.COL=grid[0].length;
        this.visited=new boolean[ROW][COL];
        Queue<int[]> queue=new LinkedList<>();
        for(int r=0;r<ROW;r++){
            for(int c=0;c<COL;c++){
                if(grid[r][c]==0){
                    queue.add(new int[]{r,c});
                }
            }
        }
        if(queue.isEmpty()){
            return ;
        }

        while(!queue.isEmpty()){
            int[] node=queue.poll();
            int row=node[0];
            int col=node[1];
            for(int[] dir:directions){
                int nr=row+dir[0];
                int nc=col+dir[1];
                if(nr<0 || nr>=ROW || nc<0 || nc>=COL || grid[nr][nc]!=INF){
                    continue;
                }
                queue.add(new int[]{nr,nc});
                grid[nr][nc]=grid[row][col]+1;
            }
        }
    }

    // public int bfs(int[][] grid,int r,int c){

    // }

    // public int dfs(int[][] grid,int r ,int c){
    //     if(r<0 || c<0 || r>=ROW || c>=COL || grid[r][c]==-1 || visited[r][c] ){
    //         return INF;
    //     }
    //     if(grid[r][c]==0){
    //         return 0;
    //     }
    //     visited[r][c]=true;
    //     int res=INF;
    //     for(int[] dir:directions){
    //         int nr=r+dir[0];
    //         int nc=c+dir[1];
    //         // if(nr>=0 && nr<ROW && nc>=0 && nc<COL && grid[nr][nc]!=-1 && !visited[nr][nc]){
    //             // grid[nr][nc]=Math.dfs(grid,nr,nc);
    //         // }
    //         int curr=dfs(grid,nr,nc);
    //         if(curr!=INF){
    //             res=Math.min(1+curr,res);
    //         }
    //     }
    //     visited[r][c]=false;
    //     return res;
    // }
}
