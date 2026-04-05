public class TrieNode {
    HashMap<Character,TrieNode> children;
    boolean isEnd;
    public TrieNode(){
        this.children=new HashMap<>();
        this.isEnd=false;
    }
    public void addWord(String word){
        TrieNode cur=this;
        for(char c:word.toCharArray()){
            if(cur.children.get(c)==null){
                cur.children.put(c,new TrieNode());
            }
            cur=cur.children.get(c);
        }
        cur.isEnd=true;
    }
}
class Solution {
    Set<String> result;
    boolean[][] visited;
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root=new TrieNode();
        for(String w:words){
            root.addWord(w);
        }
        result=new HashSet<>();
        visited=new boolean[board.length][board[0].length];
        for(int r=0;r<board.length;r++){
            for(int c=0;c<board[0].length;c++){
                dfs(board,r,c,root,"");
            }
        }
        return new ArrayList<>(result);
    }
    public void dfs(char[][] board,int r , int c, TrieNode node,String word){
        if(r<0 || c<0 || r>=board.length || c>=board[0].length || visited[r][c] ||
                !node.children.containsKey(board[r][c]))
        {
            return;
        }
        node=node.children.get(board[r][c]);
        word+=board[r][c];
        if(node.isEnd){
            result.add(word);
        }
        visited[r][c]=true;
        dfs(board,r+1,c,node,word);
        dfs(board,r-1,c,node,word);
        dfs(board,r,c+1,node,word);
        dfs(board,r,c-1,node,word);
        visited[r][c]=false;
    }

}