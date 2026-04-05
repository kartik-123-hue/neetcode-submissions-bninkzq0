class Solution {
    int ROWS,COLS;
    HashSet<Pair<Integer,Integer>> visited;
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result=new ArrayList<>();
        visited=new HashSet<>();
        ROWS=board.length;
        COLS=board[0].length;
        for(String word:words){
            //this flag is to tell that what during the iteration of r,c
            //we found the 
            boolean flag=false;
            for(int r=0;r<ROWS && !flag;r++){
                for(int c=0;c<COLS;c++){
                    //we will apply matrix here to traverse each direction to search
                    //for the word
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

    public boolean backtrack(char[][] board,int r,int c,int i,String word){
        if(i==word.length()){
            return true;
        }
        if(r<0 || c<0 || r>=ROWS || c>=COLS || word.charAt(i)!=board[r][c] || visited.contains(new Pair<>(r,c))){
            return false;
        }
        visited.add(new Pair<>(r,c));
        boolean res=backtrack(board,r+1,c,i+1,word) || backtrack(board,r-1,c,i+1,word) || backtrack(board,r,c+1,i+1,word) ||
        backtrack(board,r,c-1,i+1,word);
        visited.remove(new Pair<>(r,c));
        return res;

    }


}
