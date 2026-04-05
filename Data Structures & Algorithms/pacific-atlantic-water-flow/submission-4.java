class Solution {
    int ROW,COLS;
    boolean[][] pacific;
    boolean[][] atlantic;
    int[][] directions=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        ROW=heights.length;
        COLS=heights[0].length;
        List<List<Integer>> result=new ArrayList<>();
        pacific=new boolean[ROW][COLS];
        atlantic=new boolean[ROW][COLS];
        for(int r=0;r<ROW;r++){
            dfs(r,0,heights,pacific);
            dfs(r,COLS-1,heights,atlantic);
        }

        for(int c=0;c<COLS;c++){
            dfs(0,c,heights,pacific);
            dfs(ROW-1,c,heights,atlantic);
        }
        for(int r=0;r<ROW;r++){
            for(int c=0;c<COLS;c++){
                if(pacific[r][c] && atlantic[r][c]){
                    result.add(List.of(r,c));
                }
            }
        }
        return result;
    }

    public void dfs(int r,int c,int[][] heights,boolean[][] ocean){
        ocean[r][c]=true;
        for(int[] dir:directions){
            int nr=r+dir[0];
            int nc=c+dir[1];
            if(nr>=0 && nr<ROW && nc>=0 && nc<COLS && !ocean[nr][nc] && heights[nr][nc]>=heights[r][c]){
                dfs(nr,nc,heights,ocean);
            }
        }
    }
}
