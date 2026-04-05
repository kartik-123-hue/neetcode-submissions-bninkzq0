class Solution {
    int[] memo;
    public int rob(int[] nums) {
        //All houses at this place are arranged in a circle.
        //first is the neighbor of the last
        //2 houses cannot be broken into on the same night

        //current house you are 2(from last)
        //you can decide whether 
        //if we go to the next neighbor then we will not include the current
        memo=new int[nums.length];
        Arrays.fill(memo,-1);
        if(nums.length==1){
            return nums[0];
        }
        int firstTrack=rob(nums,nums.length-2,0);
        memo=new int[nums.length];
        Arrays.fill(memo,-1);
        int secondTrack=rob(nums,nums.length-1,1);
        return Math.max(firstTrack,secondTrack);
    }
    public int rob(int[] nums,int i,int end){
        if(i<end){
            return 0;
        }
        if(memo[i]>=0){
            return memo[i];
        }
        int adjacentToPrevious=rob(nums,i-2,end)+nums[i];
        int adjacentToCurrent=rob(nums,i-1,end);
        int result= Math.max(adjacentToPrevious,adjacentToCurrent);
        memo[i]=result;
        return result;
    }
   
}