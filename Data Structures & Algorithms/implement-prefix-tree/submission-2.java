class Trie{
    Trie[] start=new Trie[26];
    boolean isLast;
}
class PrefixTree {
    Trie root;

    public PrefixTree() {
         root=new Trie();
    }

    public void insert(String word) {
        Trie curr=root;
        for(char c:word.toCharArray()){
            if(curr.start[c-'a']==null){
                curr.start[c-'a']=new Trie();
            }
            curr=curr.start[c-'a'];
        }
        curr.isLast=true;
    }

    public boolean search(String word) {
         Trie curr=root;
        for(char c:word.toCharArray()){
            if(curr.start[c-'a']!=null){
                curr=curr.start[c-'a'];
            }
        }
        return curr.isLast;
    }

    public boolean startsWith(String prefix) {
         Trie curr=root;
        for(char c:prefix.toCharArray()){
            if(curr.start[c-'a']==null){
                return false;
            }
            curr=curr.start[c-'a'];
        }
        return true;
    }
}
