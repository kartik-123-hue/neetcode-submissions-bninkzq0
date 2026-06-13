class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count=new int[26];
        for(char c:tasks){
            count[c-'A']++;
        }

        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        for(int cnt:count){
            if(cnt>0){
                maxHeap.offer(cnt);
            }
        }
        Queue<int[]> q=new LinkedList<>();
        int currentTime=0;
        while(!maxHeap.isEmpty() || !q.isEmpty()){
            currentTime++;
            if(maxHeap.isEmpty()){

                currentTime=q.peek()[1];
            }
            else{
                int remainingCount=maxHeap.poll()-1;
                if(remainingCount>0){
                    q.offer(new int[]{remainingCount,currentTime+n});
                }
            }
            if(!q.isEmpty() && q.peek()[1]==currentTime){
                maxHeap.offer(q.poll()[0]);
            }
        }
        return currentTime;
    }
}
