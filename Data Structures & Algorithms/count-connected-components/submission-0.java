class Solution {
    public int countComponents(int n, int[][] edges) {
        int res=0;
        boolean[] visited=new boolean[n];
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(i,new ArrayList<>());
        }
        for(int[] edge:edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i,visited,adj);
                res++;
            }
        }
        return res;
    }
    public void dfs(int node,boolean[] visited,List<List<Integer>> adj){
        if(visited[node]){
            return;
        }
        visited[node]=true;
        for(int i:adj.get(node)){
            if(!visited[i]){
                dfs(i,visited,adj);
            }
        }
    }
}
