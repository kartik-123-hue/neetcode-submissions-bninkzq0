class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates,target,0,curr,0);
        return res;
    }

    public void backtrack(int[] nums,int target,int total,List<Integer> curr,int i){
        if(total==target){
            res.add(new ArrayList<>(curr));
            return;
        }

        if(total>target ||i==nums.length){
            return;
        }
        curr.add(nums[i]);
        backtrack(nums,target,total+nums[i],curr,i+1);
        curr.remove(curr.size()-1);
        while(i+1<nums.length && nums[i]==nums[i+1]){
            i++;
        }
        backtrack(nums,target,total,curr,i+1);
    }
}
