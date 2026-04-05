class Solution {
    public int[] productExceptSelf(int[] nums) {
        //1 2 4 6
        //1    1   2  8 48
        //48  48  24  6  1
        int n=nums.length;
        int[] prefix=new int[n+1];
        int[] suffix=new int[n+1];

        Arrays.fill(prefix,1);
        Arrays.fill(suffix,1);

        for(int i=0;i<n;i++){
            prefix[i+1]=nums[i]*prefix[i];
        }
        for(int i=nums.length-1;i>=0;i--){
            suffix[i]=nums[i]*suffix[i+1];
        }
        /*
            
        */
        for(int i=1;i<n+1;i++){
            nums[i-1]=prefix[i-1]*suffix[i];
        }
        return nums;
    }
}  
