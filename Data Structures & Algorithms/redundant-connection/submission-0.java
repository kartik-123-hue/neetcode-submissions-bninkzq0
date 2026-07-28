class Solution {
    Map<Integer,List<Integer>> preMap=new HashMap<>();

    public int[] findRedundantConnection(int[][] edges) {
        for(int i=1;i<=edges.length;i++){
            preMap.put(i,new ArrayList<>());
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            //  System.out.println("u"+u+"v"+v);
            preMap.get(u).add(v);
            preMap.get(v).add(u);
            boolean[] visit=new boolean[edges.length+1];
            if(dfs(u,-1,visit)){
                return edge;
            }
        }
        return new int[0];
    }
    public boolean dfs(int node,int parent,boolean[] visit){
        if(visit[node]){
            return true;
        }
        visit[node]=true;
        for(int e:preMap.get(node)){
            if(e==parent){
                continue;
            }
            if(dfs(e,node,visit)){
                return true;
            }
        }
        return false;
    }
}
