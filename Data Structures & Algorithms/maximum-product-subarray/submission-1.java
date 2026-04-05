class Solution {
    public int maxProduct(int[] nums) {
        int res=nums[0];
        int curr_max=1;
        int curr_min=1;

        for(int num:nums)
        {
            int temp=curr_max*num;
            curr_max=Math.max(Math.max(temp,curr_min*num),num);
            curr_min=Math.min(Math.min(temp,curr_min*num),num);
            res=Math.max(res,curr_max);
        }
        return res;

    }
}
