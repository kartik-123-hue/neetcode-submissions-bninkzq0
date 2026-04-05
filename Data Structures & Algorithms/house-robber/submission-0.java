class Solution {
    public int rob(int[] nums) {
        int prev1=0;
        int prev2=0;
        for(int n:nums){
            int temp=prev1;
            prev1=Math.max(n+prev2,prev1);
            prev2=temp;
        }
        return prev1;
    }
}
