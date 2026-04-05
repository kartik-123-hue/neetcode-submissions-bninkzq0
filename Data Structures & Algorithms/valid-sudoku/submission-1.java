class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n=board.length;
        int m=board[0].length;

        boolean[][] row=new boolean[n][m];
        boolean[][] col=new boolean[n][m];
        boolean[][] box=new boolean[n][m];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    //what this val actually index
                    //that indiacted that in that row
                    //that number is already marked as as true
                    //and we do -1 why ? becuase we want the index
                    //as 1-9 are digits but 0-8 will be the index that will be marked
                    //true
                    int numIndex=board[i][j]-'1';
                    if(row[i][numIndex]){
                        return false;
                    }
                    else{
                        row[i][numIndex]=true;
                    }

                    if(col[j][numIndex]){
                        return false;
                    }
                    else{
                        col[j][numIndex]=true;
                    }
                    //this is another important thing 
                    //to know how to calculate the box index
                    //i/3 + j/3 will tell you which box you are 
                    //but when you reach the next row that will so we do a 
                    //i/3*3+j/3 


                    /*
                    imagine we have 9 boxes
                    okay?
                    // now 
                    (0/3+0/3 will go till 2/3)
                    (0/3+3/3 will go till 5/3)
                    (0/3+6/3 will go till 8/3)

                    this will give 0 1 2 (box numbers)

                    but if we go to the next row
                    1/3+1/3 will go till 2/3 and this will give us 0
                    but we have already coverd this and that is wrong so?

                    so we multiply the row(i/3)*3 to say that we have alredy covevered the 
                    the last 3 box and now you start from (i/3)*3+j/3
                    */
                    int boxNumber=(i/3)*3+j/3;

                    if(box[boxNumber][numIndex]){
                        return false;
                    }
                    else{
                        box[boxNumber][numIndex]=true;
                    }
                }

            }
        }
        return true;
    }
}
