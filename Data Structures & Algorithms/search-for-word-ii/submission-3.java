class Solution {
    int ROWS,COLS;
    HashSet<Pair<Integer,Integer>> set;
    public List<String> findWords(char[][] board, String[] words) {
        ROWS=board.length;
        COLS=board[0].length;
        List<String> result=new ArrayList<>();
        set=new HashSet<>();
        for(String word:words){
            boolean flag=false;
            for(int r=0;r<ROWS && !flag;r++){
                for(int c=0;c<COLS;c++){
                    if(backtrack(board,r,c,0,word)){
                        result.add(word);
                        flag=true;
                        break;
                    }
                }
            }
        }
        return result;
    }
    public boolean backtrack(char[][] board,int r ,int c ,int i, String word){
        if(i==word.length()){
            return true;
        }
        if(r<0 || c<0 || r>=ROWS || c>=COLS || word.charAt(i)!=board[r][c] || set.contains(new Pair<>(r,c))){
            return false;
        }
        set.add(new Pair<>(r,c));
        boolean res=backtrack(board,r,c+1,i+1,word) || backtrack(board,r,c-1,i+1,word)  || backtrack(board,r+1,c,i+1,word) || backtrack(board,r-1,c,i+1,word) ;
        set.remove(new Pair<>(r,c));
        return res;
    }
}
