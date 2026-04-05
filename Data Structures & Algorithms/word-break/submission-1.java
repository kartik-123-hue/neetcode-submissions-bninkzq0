
class TrieNode{
    TrieNode[] children;
    boolean isEnd=false;
    TrieNode(){
        this.children=new TrieNode[26];
    }
}
class Solution {
    TrieNode root;

    public void addWord(String word){
        TrieNode curr=root;
        for(char c:word.toCharArray()){
            int i=c-'a';
            if(curr.children[i]==null){
                curr.children[i]=new TrieNode();
            }
            curr=curr.children[i];
        }
        curr.isEnd=true;
    }

    public boolean search(String word){
        System.out.println(word);
        TrieNode curr=root;
        for(char c:word.toCharArray()){
            int i=c-'a';
            if(curr.children[i]==null){
                return false;
            }
            curr=curr.children[i];
        }
        return curr.isEnd;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        root=new TrieNode();
//        List<String >
        for(String word:wordDict){
            addWord(word);
        }
        int n=s.length();
        // String word="";
        boolean[] dp=new boolean[n+1];
        dp[n]=true;
        // for(int i=0;i<n;i++){
        //     word+=s.charAt(i);
        //     if(search(word)){
        //         word="";
        //     }
        // }
        // return word.equalsIgnoreCase("");
        int maxLen=0;
        for(String word:wordDict){
            maxLen=Math.max(maxLen,word.length());
        }
        for(int i=n-1;i>=0;i--){
            for(int j=i;j<Math.min(n,i+maxLen);j++){
                if(search(s.substring(i,j+1))){
                    dp[i]=dp[j+1];
                    if(dp[i]){
                        break;
                    }
                }
            }
        }
        return dp[0];
    }
}
