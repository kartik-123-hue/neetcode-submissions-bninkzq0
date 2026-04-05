class Solution {
    HashSet<Integer> visited;
    HashMap<Integer,ArrayList<Integer>> children;
    public boolean validTree(int n, int[][] edges) {
        visited=new HashSet<>();
        children=new HashMap<>();
        for(int i=0;i<n;i++){
            children.put(i,new ArrayList<>());
        }
        for(int[] edge:edges){
            children.get(edge[0]).add(edge[1]);
            children.get(edge[1]).add(edge[0]);
        }
        // System.out.println(children.toString());
        // for(int i=0;i<n;i++){
            if(!dfs(0,-1)){
                //cycle detected
                return false;
            }
        // }
        // System.out.println(visited.toString());
        return visited.size()==n;
    }
    public boolean dfs(int n,int parent){
        System.out.println(visited.toString());
        if(visited.contains(n)){
            return false;
        }
        // if(children.get(n).isEmpty()){
        //     //all edges visited
        //     return true;
        // }
        visited.add(n);
        for(int i:children.get(n)){
            if(i==parent){
                continue;
            }
            if(!dfs(i,n)){
                return false;
            }
        }
        // visited.remove(n);
        // children.put(n,new ArrayList<>());
        return true;
    }
}
