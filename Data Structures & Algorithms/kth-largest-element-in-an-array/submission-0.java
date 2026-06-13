class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        for(int n:nums){
            maxHeap.offer(n);
        }

        int result=-1001;
        while(k!=0){
            result=maxHeap.poll();
            k--;
        }
        return result;
    }
}
