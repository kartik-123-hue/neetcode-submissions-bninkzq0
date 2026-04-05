class Solution {
    int[][] directions=new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
    int ROWS,COLS;
    public int numIslands(char[][] grid) {
        ROWS=grid.length;
        COLS=grid[0].length;
        int islands=0;
        for(int r=0;r<ROWS;r++){
            for(int c=0;c<COLS;c++){
                if(grid[r][c]=='1'){
                    dfs(grid,r,c);
                    islands++;
                }
            }
        }
        return islands;
    }
    public void dfs(char[][] grid,int r,int c){
        Stack<int[]> stack=new Stack<>();
        grid[r][c]='0';
        stack.push(new int[]{r,c});
        while(!stack.isEmpty()){
            int[] node=stack.pop();
            int row=node[0];
            int col=node[1];
            for(int[] dir:directions){
                int nr=row+dir[0];
                int nc=col+dir[1];
                if(nr>=0 && nc>=0 && nr<grid.length && nc<grid[0].length 
                && grid[nr][nc]=='1'){
                    stack.push(new int[]{nr,nc});
                    grid[nr][nc]='0';
                }
            }
        }
    }
}
