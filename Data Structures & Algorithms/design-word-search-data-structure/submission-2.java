public class TrieNode{
    TrieNode[] children;
    boolean isLast;
    public TrieNode(){
        children=new TrieNode[26];
    }
}
class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        this.root=new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr=root;
        for(char c:word.toCharArray()){
            int index=c-'a';
            if(curr.children[index]==null){
                curr.children[index]=new TrieNode();
            }
            curr=curr.children[index];
        }
        curr.isLast=true;
    }

    public boolean search(String word) {
        return dfs(word,0,root);
    }

    public boolean dfs(String word,int i,TrieNode root){
        TrieNode curr=root;
        for(int j=i;j<word.length();j++){
            char currChar=word.charAt(j);
            if(currChar=='.'){
                for(TrieNode child:curr.children){
                    if(child!=null && dfs(word,j+1,child)){
                        return true;
                    }
                }
                return false;
            }
            else{
                int index=currChar-'a';
                if(curr.children[index]==null){
                    return false;
                }
                curr=curr.children[index];
            }
        }
        return curr.isLast;
    }
}
