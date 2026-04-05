class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row=new boolean[9][9];
        boolean[][] col=new boolean[9][9];
        boolean[][] box=new boolean[9][9];

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
               if(board[i][j]!='.'){
                int val=board[i][j]-'1';
                if(row[i][val]){
                    return false;
                }
                else{
                    row[i][val]=true;
                }

                if(col[j][val]){
                    return false;
                }
                else{
                    col[j][val]=true;
                }

                int boxIndex=(i/3)*3+(j/3);
                if(box[boxIndex][val]){
                    return false;
                }
                else{
                    box[boxIndex][val]=true;
                }
               }
            }
        }
        return true;
    }
}