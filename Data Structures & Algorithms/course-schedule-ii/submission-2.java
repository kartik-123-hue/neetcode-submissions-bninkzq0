class Solution {
    HashMap<Integer,List<Integer>> directedMap=new HashMap<>();
    Set<Integer> visiting=new HashSet<>();
    Set<Integer> cycle=new HashSet<>();
    List<Integer> result=new ArrayList<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for(int i=0;i<numCourses;i++){
            directedMap.put(i,new ArrayList<>());
        }
        for(int[] preq:prerequisites){
            directedMap.get(preq[0]).add(preq[1]);
        }
        System.out.println("directedMap prepared "+directedMap.toString());
        for(int i=0;i<numCourses;i++){
            if(!dfs(i)){
               return new int[0];
            }
        }
        int[] res=new int[result.size()];
        for(int i=0;i<result.size();i++){
            res[i]=result.get(i);
        }
        return res;
    }
    public boolean dfs(int c){
        if(cycle.contains(c)){
            return false;
        }
        if(visiting.contains(c)){
            return true;
        }
        cycle.add(c);
        for(int n:directedMap.getOrDefault(c,Collections.emptyList())){
            if(!dfs(n)){
                return false;
            }
        }
        cycle.remove(c);
        visiting.add(c);
        result.add(c);
        return true;
    }
}
