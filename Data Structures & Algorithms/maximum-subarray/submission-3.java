class Solution {

    // if we look at the brute force
    //[2,-3,4,-2,2,1,-1,4]
    //2-3+4-2+2+1-1+4
    public int maxSubArray(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int res=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            int max=nums[i];
            res=Math.max(max,res);
            for(int j=i+1;j<nums.length;j++){
                max+=nums[j];
                res=Math.max(max,res);
            }
            res=Math.max(max,res);
        }
        return res;
    }
}
