public class Trie{
    Trie[] children;
    boolean isLast;
    public Trie(){
        this.children=new Trie[26];
    }
}
class PrefixTree {
    Trie root;

    public PrefixTree() {
         this.root=new Trie();
    }

    public void insert(String word) {
        Trie curr=root;
        for(char c:word.toCharArray()){
            int index=c-'a';
            if(curr.children[index]==null){
                curr.children[index]=new Trie();
            }
            curr=curr.children[index];
        }
        curr.isLast=true;
    }

    public boolean search(String word) {
        Trie curr=root;
        for(char c:word.toCharArray()){
            int index=c-'a';
            if(curr.children[index]==null){
                return false;
            }
            curr=curr.children[index];
        }
        return curr.isLast;
    }

    public boolean startsWith(String prefix) {
        Trie curr=root;
        for(char c:prefix.toCharArray()){
            int index=c-'a';
            if(curr.children[index]==null){
                return false;
            }
            curr=curr.children[index];
        }
        return true;
    }
}
