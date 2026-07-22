class Solution {
    // HashMap<Integer,List<Integer>> directedMap=new HashMap<>();
    // Set<Integer> visiting=new HashSet<>();
    // Set<Integer> cycle=new HashSet<>();
    // List<Integer> result=new ArrayList<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
         HashMap<Integer,List<Integer>> directedMap=new HashMap<>();
    Set<Integer> visiting=new HashSet<>();
    Set<Integer> cycle=new HashSet<>();
    List<Integer> result=new ArrayList<>();
       for(int[] pair:prerequisites){
        directedMap.computeIfAbsent(pair[0],k->new ArrayList()).add(pair[1]);
       }
        System.out.println("directedMap prepared "+directedMap.toString());
        for(int i=0;i<numCourses;i++){
            if(!dfs(i,directedMap,cycle,visiting,result)){
               return new int[0];
            }
        }
        int[] res=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            res[i]=result.get(i);
        }
        return res;
    }
    public boolean dfs(int c,Map<Integer,List<Integer>> directedMap,Set<Integer> cycle,Set<Integer> visiting,List<Integer> result){
        if(cycle.contains(c)){
            return false;
        }
        if(visiting.contains(c)){
            return true;
        }
        cycle.add(c);
        for(int n:directedMap.getOrDefault(c,Collections.emptyList())){
            if(!dfs(n,directedMap,cycle,visiting,result)){
                return false;
            }
        }
        cycle.remove(c);
        visiting.add(c);
        result.add(c);
        return true;
    }
}
