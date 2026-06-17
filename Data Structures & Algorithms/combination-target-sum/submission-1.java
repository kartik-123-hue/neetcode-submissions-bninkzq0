class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();
        backtrack(nums,curr,target,0);
        return res;
    }
    public void backtrack(int[] nums,List<Integer> curr,int target,int i){
        if(target==0){
            res.add(new ArrayList<>(curr));
            return ;
        }
        if(target<0 || i>=nums.length){return;}
        curr.add(nums[i]);
        backtrack(nums,curr,target-nums[i],i);
        curr.remove(curr.size()-1);
        backtrack(nums,curr,target,i+1);
    }
}
