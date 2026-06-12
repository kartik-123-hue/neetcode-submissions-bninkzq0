class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        for(int n:stones){
            maxHeap.offer(n);
        }
         System.out.println("maxHeap : {}"+maxHeap.toString());
        while(maxHeap.size()>1){
            System.out.println("while calculation maxHeap :"+maxHeap.toString());
            int y=maxHeap.poll();
            int x=maxHeap.poll();
            System.out.println("x:"+x+"y:"+y);
            if(x<y){
                maxHeap.add(y-x);
            }
        }
        return maxHeap.size()==0?0:maxHeap.peek();
    }
}
