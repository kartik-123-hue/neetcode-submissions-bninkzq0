class Solution {
    
    public String foreignDictionary(String[] words) {
       HashMap<Character,Integer> indegree=new HashMap<>();
       HashMap<Character,HashSet<Character>> adj=new HashMap<>();
       for(String word:words){
            for(char c:word.toCharArray()){
                indegree.putIfAbsent(c,0);
                adj.putIfAbsent(c,new HashSet<>());
            }
       }
       for(int i=0;i<words.length-1;i++){
            String w1=words[i];
            String w2=words[i+1];
            int minLen=Math.min(w1.length(),w2.length());
            if(w1.length()>w2.length() && w1.substring(0,minLen).equals(w2.substring(0,minLen))){
                return "";
            }
            for(int j=0;j<minLen;j++){
                if(w1.charAt(j)!=w2.charAt(j)){
                    if(!adj.get(w1.charAt(j)).contains(w2.charAt(j))){
                        adj.get(w1.charAt(j)).add(w2.charAt(j));
                        indegree.put(w2.charAt(j),indegree.get(w2.charAt(j))+1);
                    }
                    break;
                }
            }
       }
        Queue<Character> queue=new LinkedList<>();
        for(char c:indegree.keySet()){
                if(indegree.get(c)==0){
                    queue.offer(c);
                }
        }
        StringBuilder res=new StringBuilder();
        while(!queue.isEmpty()){
            char node=queue.poll();
            res.append(node);
            for(char c:adj.get(node)){
                indegree.put(c,indegree.get(c)-1);
                if(indegree.get(c)==0){
                    queue.offer(c);
                }
            }
        }
        System.out.println(indegree.toString());
         System.out.println(adj.toString());
        if(res.length()!=indegree.size()){
            return "";
        }
        return res.toString();
    }
}
