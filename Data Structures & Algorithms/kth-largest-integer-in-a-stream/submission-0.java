class KthLargest {
    PriorityQueue<Integer> minHeap;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k=k;
        minHeap=new PriorityQueue<>();
        for(int n:nums){
            minHeap.offer(n);
        }
        while(minHeap.size()>k){
            minHeap.poll();
        }
    }

    
    public int add(int val) {
        minHeap.offer(val);
        while(minHeap.size()>k){
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
