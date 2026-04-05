class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deq=new LinkedList<>();
        int[] res=new int[nums.length-k+1];
        int j=0;
        for(int i=0;i<nums.length;i++){
            while(!deq.isEmpty() && nums[deq.getLast()]<nums[i]){
                deq.removeLast();
            }
            deq.addLast(i);
            if(j>deq.getFirst()){
                deq.removeFirst();
            }
            
            if((i+1)>=k){
                res[j++]=nums[deq.getFirst()];
            }
        }
       
        return res;
    }
}
