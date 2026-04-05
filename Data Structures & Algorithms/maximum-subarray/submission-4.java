class Solution {
    public int maxSubArray(int[] nums) {
        int max_sum=Integer.MIN_VALUE;
        int curr_sum=0;
        for(int num:nums){
            // int curr_sum=num;
            if(curr_sum<0){
                curr_sum=0;
            }
            curr_sum+=num;
            max_sum=Math.max(curr_sum,max_sum);
        }
        return max_sum;
    }
}
