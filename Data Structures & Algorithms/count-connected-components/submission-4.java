class Solution {
    Map<Integer,List<Integer>> adjList=new HashMap<>();
    HashSet<Integer> visited=new HashSet<>();
    public int countComponents(int n, int[][] edges) {
        for(int i=0;i<n;i++){
            adjList.put(i,new ArrayList<>());
        }
        for(int[] edge:edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
       int res=0;
        for(int i=0;i<n;i++){
            if(!visited.contains(i)){
                dfs(i);
                res++;
            }
        }
        return res;
    }
    public void dfs(int curr){
        if(visited.contains(curr)){
            return;
        }
        visited.add(curr);
        for(int next:adjList.get(curr)){
             if(!visited.contains(next)){
                dfs(next);
            }
        }
    }
}
