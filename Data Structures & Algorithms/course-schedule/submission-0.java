class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree=new int[numCourses];
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(i,new ArrayList<>());
        }
        for(int[] preq:prerequisites){
            indegree[preq[1]]++;
            adj.get(preq[0]).add(preq[1]);
        }

        Queue<Integer> queue=new LinkedList<>();

        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                queue.offer(i);
            }
        }
        int finish=0;
        while(!queue.isEmpty()){
            int node=queue.poll();
            finish++;
            for(int n:adj.get(node)){
                indegree[n]--;
                if(indegree[n]==0){
                    queue.offer(n);
                }
            }
        }
        return finish==numCourses;
    }
}
