class Solution {
    int ROWS;
    int COLS;   
    int[][] directions=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.ROWS=heights.length;
        this.COLS=heights[0].length;
        boolean[][] pacific=new boolean[ROWS][COLS];
        boolean[][] atlantic=new boolean[ROWS][COLS];
        List<List<Integer>> res=new ArrayList<>();
        for(int r=0;r<ROWS;r++){
            dfs(r,0,heights,pacific);
            dfs(r,COLS-1,heights,atlantic);
        }
        for(int c=0;c<COLS;c++){
            dfs(0,c,heights,pacific);
            dfs(ROWS-1,c,heights,atlantic);
        }
        for(int r=0;r<ROWS;r++){
            for(int c=0;c<COLS;c++){
                if(pacific[r][c] && atlantic[r][c]){
                    res.add(Arrays.asList(r,c));
                }
            }
        }
        return res;
    }
    public void dfs(int r,int c,int[][] heights,boolean[][] ocean){
        ocean[r][c]=true;
        for(int[] dir:directions){
            int nr=r+dir[0];
            int nc=c+dir[1];
            if(nr>=0 && nc>=0 && nr<ROWS && nc<COLS && !ocean[nr][nc] && heights[nr][nc]>=heights[r][c]){
                dfs(nr,nc,heights,ocean);
            }
        }
    }
}
