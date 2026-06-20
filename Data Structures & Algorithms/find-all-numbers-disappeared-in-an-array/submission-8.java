class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int length=nums.length;
        int[] hash=new int[length+1];
        for(int n:nums){
            hash[n]++;
        }
        List<Integer> res=new ArrayList<>();
        for(int i=1;i<=length;i++){
            if(hash[i]==0){
                res.add(i);
            }
        }
        return res;
    }
}