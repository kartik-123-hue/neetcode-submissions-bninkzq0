class Solution {
    public int maxSubArray(int[] nums) {
        //divide and conquer
        return divAndC(nums,0,nums.length-1);
    }
    public int divAndC(int[] nums,int l,int r){
        if(l>r){
            return Integer.MIN_VALUE;
        }
        int mid=l+(r-l)/2;
        int left_sum=0;
        int curr_sum=0;
        for(int i=mid-1;i>=l;i--){
            curr_sum+=nums[i];
            left_sum=Math.max(left_sum,curr_sum);
        }
        curr_sum=0;
        int right_sum=0;
        for(int i=mid+1;i<=r;i++){
            curr_sum+=nums[i];
            right_sum=Math.max(right_sum,curr_sum);
        }
        // System.out.println("range : "+l+"-"+r+" left : "+left_sum+" right: "+right_sum +" including mid : "+(left_sum+nums[mid]+right_sum));
        return Math.max(divAndC(nums,l,mid-1),Math.max(divAndC(nums,mid+1,r),left_sum+nums[mid]+right_sum));
    }
}
