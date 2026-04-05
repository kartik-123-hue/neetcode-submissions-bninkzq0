class Solution {
    HashMap<Character,HashSet<Character>> adj;
    HashMap<Character,Boolean> visited;
    List<Character> result;
    public String foreignDictionary(String[] words) {
        adj=new HashMap<>();
        //we initialise the adj list with hashset so that no cycles occur here 
        for(String word:words){
            for(char c:word.toCharArray()){
                adj.putIfAbsent(c,new HashSet<>());
            }
        }

        for(int i=0;i<words.length-1;i++){
            String word1=words[i];
            String word2=words[i+1];
            //min len determines the number of char we can 
            //validate from each word1 and word2
            int minLen=Math.min(word1.length(),word2.length());

            //for example
            //abc comes before ab
            //that means abc should be a prefix of ab but thats impossible so we return ""\
            //there also can be possibility that
            //hrf and er
            //but here we compare hr and er they are not equals so theres possibility that that we can 
            //find a different char 
            //and we did h->e so we are on track 
            if(word1.length()>word2.length() && word1.substring(0,minLen).equalsIgnoreCase(word2.substring(0,minLen))){
                return "";
            }
            for(int j=0;j<minLen;j++){
                if(word1.charAt(j)!=word2.charAt(j)){
                    adj.get(word1.charAt(j)).add(word2.charAt(j));
                    break;
                }
            }
        }
            visited=new HashMap<>();
            result=new ArrayList<>();
            for(Map.Entry<Character,HashSet<Character>> entry:adj.entrySet()){
                char c=entry.getKey();
                if(dfs(c)){
                    return "";
                }
            }
            StringBuilder builder=new StringBuilder();
            for(char c:result){
                builder.append(c);
            }
            return builder.reverse().toString();
        }


    public boolean dfs(char c){
        if(visited.containsKey(c)){
            return visited.get(c);
        }
        visited.put(c,true);
        for(char ch:adj.get(c)){
            if(dfs(ch)){
                return true;
            }
        }
        visited.put(c,false);
        //post DFS adding it after reaching the last or already visted node
        result.add(c);
        return false;
    }
}
