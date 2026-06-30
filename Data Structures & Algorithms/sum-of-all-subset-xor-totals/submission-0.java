class Solution {
    // ArrayList<Integer> arr=new ArrayList<>();
    public int subsetXORSum(int[] nums) {
        int[] sum=new int[1];
        backtrack(sum,nums,0,new ArrayList<>());
        return sum[0];
    }
    public void backtrack(int[] sum,int[] nums,int i,ArrayList<Integer> subset){
        // System.out.println("what is i ?"+i);
        // if(i==nums.length){
        //     return;
        // }
        // sum[0]=nums[i]^sum[0];
        // backtrack(sum,nums,i+1);
        // backtrack(sum,nums,i+1);
        int xorr=0;
        for(int num:subset){
            xorr^=num;
        }
        sum[0]+=xorr;
        for(int j=i;j<nums.length;j++){
            subset.add(nums[j]);
            backtrack(sum,nums,j+1,subset);
            subset.remove(subset.size()-1);
        }
    }
}