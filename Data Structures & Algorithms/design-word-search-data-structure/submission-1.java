public class TrieNode {
    TrieNode[] children;
    boolean isEnd;
    public TrieNode(){
        this.children=new TrieNode[26];
        this.isEnd=false;
    }
}
class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root=new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur=root;
        for(char c:word.toCharArray()){
            int i=c-'a';
            if(cur.children[i]==null){
                cur.children[i]=new TrieNode();
            }
            cur=cur.children[i];
        }
        cur.isEnd=true;
    }

    public boolean search(String word) {
        return dfs(word,0,root);
    }
    public boolean dfs(String word,int j,TrieNode root){
        TrieNode cur=root;
        for(int i=j;i<word.length();i++){
            char c=word.charAt(i);
            if(c=='.'){
                for(TrieNode child:cur.children){
                    if(child!=null && dfs(word,i+1,child)){
                        return true;
                    }
                }
                return false;
            }
            else{
                int index=c-'a';
                if(cur.children[index]==null){
                    return false;
                }
                cur=cur.children[index];
            }
        }
        return cur.isEnd;
    }
}
