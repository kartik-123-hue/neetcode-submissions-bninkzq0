class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();
        boolean[] pick=new boolean[nums.length];
        backtrack(nums,curr,pick);
        return res;
    }

    public void backtrack(int[] nums,List<Integer> curr,boolean[] pick){
        if(curr.size()==nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!pick[i]){
                curr.add(nums[i]);
               pick[i]=true;
                backtrack(nums,curr,pick);
                curr.remove(curr.size()-1);
                pick[i]=false;
            }
        }
    }
}
