class Solution {
    HashMap<Integer,List<Integer>> preqMap=new HashMap<>();
    Set<Integer> visited=new HashSet<>();
    public boolean validTree(int n, int[][] edges) {
        //first thing to remeber this undirected graph
        for(int i=0;i<n;i++){
            preqMap.put(i,new ArrayList<>());
        }
        for(int[] edge:edges){
            preqMap.get(edge[0]).add(edge[1]);
            preqMap.get(edge[1]).add(edge[0]);
        }
        if(!dfs(0,-1)){
            return false;
        }
        return visited.size()==n;
    }

    public boolean dfs(int edge,int parent){
        if(visited.contains(edge)){
            return false;
        }
        visited.add(edge);
        for(int e:preqMap.getOrDefault(edge,Collections.emptyList())){
            if(e==parent){
                continue;
            }
              if(!dfs(e,edge)){
                return false;
            }
        }
        return true;
    }
}
