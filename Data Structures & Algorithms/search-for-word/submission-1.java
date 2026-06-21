class Solution {
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;
        visited=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(dfs(board,i,j,0,word)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board,int r,int c,int index,String word){
        if(index==word.length()){
            return true;
        }
        if(r<0 || c<0 || r>=board.length || c>=board[0].length || board[r][c]!=word.charAt(index) || visited[r][c]){
            return false;
        }
        visited[r][c]=true;
        boolean res=dfs(board,r,c+1,index+1,word) ||dfs(board,r+1,c,index+1,word) || dfs(board,r,c-1,index+1,word) || dfs(board,r-1,c,index+1,word);
        visited[r][c]=false;
        return res;
    }
}
