class Solution {
    int directions[][]=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    int ROWS,COLS;
    boolean pac[][],atl[][];
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res=new ArrayList<>();
       ROWS=heights.length;
       COLS=heights[0].length;
       pac=new boolean[ROWS][COLS];
       atl=new boolean[ROWS][COLS];
       for(int r=0;r<ROWS;r++){
            dfs(r,0,pac,heights);
            dfs(r,COLS-1,atl,heights);
       }

       for(int c=0;c<COLS;c++){
            dfs(0,c,pac,heights);
            dfs(ROWS-1,c,atl,heights);
       }

       for(int r=0;r<ROWS;r++){
        for(int c=0;c<COLS;c++){
            if(pac[r][c] && atl[r][c]){
                res.add(List.of(r,c));
            }
        }
       }
       return res;
    }

    public void dfs(int r,int c,boolean[][] ocean,int[][] heights){
        ocean[r][c]=true;
        for(int[] dir:directions){
            int nr=r+dir[0],nc=c+dir[1];
            if(nr>=0 && nr<ROWS && nc>=0 && nc<COLS &&
            !ocean[nr][nc] && heights[nr][nc]>=heights[r][c]){
                dfs(nr,nc,ocean,heights);
            }
        }
    }
}
