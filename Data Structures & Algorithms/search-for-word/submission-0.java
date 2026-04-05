class Solution {
    int ROWS,COLS;
    Set<Pair<Integer,Integer>> set;
    public boolean exist(char[][] board, String word) {
        ROWS=board.length;
        COLS=board[0].length;
        set=new HashSet<>();
        for(int r=0 ;r<ROWS;r++){
            for(int c=0;c<COLS;c++){
                if(backtrack(board,r,c,0,word)){
                    return true;
                }
            }
        }
        return false;
    }


    public boolean backtrack(char[][] board ,int r ,int c,int i,String word){
        if(i==word.length()){
            return true;
        }
        if(r<0 || c<0 || r>=ROWS || c>=COLS || board[r][c]!=word.charAt(i) || set.contains(new Pair<>(r,c))){
            return false;
        }
        set.add(new Pair<>(r,c));
        boolean res=backtrack(board,r+1,c,i+1,word) || backtrack(board,r,c+1,i+1,word) || backtrack(board,r-1,c,i+1,word) || backtrack(board,r,c-1,i+1,word);
        set.remove(new Pair<>(r,c));
        return res;
    }
}