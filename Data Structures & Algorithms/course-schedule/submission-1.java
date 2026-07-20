class Solution {
    Map<Integer,List<Integer>> directedMap=new HashMap<>();
    Set<Integer> visiting=new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int i=0;i<numCourses;i++){
            directedMap.put(i,new ArrayList<>());
        }
        for(int[] node:prerequisites){
            directedMap.get(node[0]).add(node[1]);
        }

       for(int c=0;c<numCourses;c++){
            if(!dfs(c)){
                return false;
            }
       }
       return true;
    }
    public boolean dfs(int c){
        if(visiting.contains(c)){
            return false;
        }
        if(directedMap.get(c).isEmpty()){
            return true;
        }
        visiting.add(c);
        for(int pre:directedMap.get(c)){
            if(!dfs(pre)){
                return false;
            }
        }
        visiting.remove(c);
        return true;
    }
}
