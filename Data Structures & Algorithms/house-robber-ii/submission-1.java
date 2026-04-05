class Solution {
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        return Math.max(rob(nums,nums.length-2,0),rob(nums,nums.length-1,1));
    }
    public int rob(int[] nums,int start,int end){
        int prev1=0;
        int prev2=0;
        for(int i=start;i>=end;i--){
            int temp=prev1;
            prev1=Math.max(nums[i]+prev2,prev1);
            prev2=temp;
        }
        return prev1;
    }
}
