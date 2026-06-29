class Solution {
    public int longestMonotonicSubarray(int[] nums) {
       int n=nums.length;
       int res=1;
       for(int i=0;i<n-1;i++){
        int currLen=1;
        for(int j=i+1;j<n;j++){
            //the condition clever way to say that my 
            // my sub array was increasing is it still increasing at nums[j-1]<nums[j]
            // or my sub array was decreasing is it still decreasing at nums[j-1]<nums[j]
            if(nums[j]==nums[j-1] || (nums[i]<nums[i+1]) != (nums[j-1]<nums[j])){
                break;
            }
            currLen++;
        }
        res=Math.max(res,currLen);
       }
       return res;
    }
}