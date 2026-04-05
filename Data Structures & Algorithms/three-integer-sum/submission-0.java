class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        /*
        we can write this sum as
        nums[i] + nums[j] + nums[k] == 0
        -nums[i]=nums[j]+nums[k]

        now j=i+1 and k=n-1;

        where we will check if nums[j]+nums[k]=target
        if its less than the target as we sorted we will j++
        and its more then we will shorten the gap k--;

        we need to take care of the duplicates 
        lets j+1 and j+2 are same we get an ans at k
        when we go to j+2 and k we will get the same triplet so we need to skip them
        

        */

        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int target=-nums[i];
            int l=i+1;
            int r=nums.length-1;

            while(l<r){
                int sum=nums[l]+nums[r];
                if(sum<target){
                    l++;
                }
                else if(sum>target){
                    r--;
                }
                else{
                    result.add(List.of(nums[i],nums[l],nums[r]));
                    l++;
                    r--;
                    while(l<r && nums[l]==nums[l-1]){
                        l++;
                    }
                }
            }
        }
        return result;
    }
}
