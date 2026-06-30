public class Trie{
    Trie[] chars=new Trie[26];
    boolean isLast;
}

class WordDictionary {
    Trie root;

    public WordDictionary() {
        root=new Trie();
    }

    public void addWord(String word) {
        Trie curr=root;
        for(char c:word.toCharArray()){
            int index=c-'a';
            if(curr.chars[index]==null){
                curr.chars[index]=new Trie();
            }
            curr=curr.chars[index];
        }
        curr.isLast=true;
    }

    public boolean search(String word) {
        return dfs(word,0,root);
    }
    public boolean dfs(String word,int i,Trie root){
        Trie curr=root;
        for(int j=i;j<word.length();j++){
            if(word.charAt(j)!='.'){
                int index=word.charAt(j)-'a';
                if(curr.chars[index]==null){
                    return false;
                }
                curr=curr.chars[index];
            }
            else{
                for(Trie child:curr.chars){
                    if(child!=null && dfs(word,j+1,child)){
                        return true;
                    }
                }
                return false;
            }
        }
        return curr.isLast;
    }
}
