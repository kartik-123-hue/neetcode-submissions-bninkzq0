class Solution {
    public int[] twoSum(int[] nums, int target) {
        //nums[i] + nums[j] == target
        //i != j

        //nums = [3,4,5,6], target = 7
        //a+b=target
        //a=target-b a should exist map to satify that target can we found
        //we keep a tracker 
        //x=7-3=4
        //map is empty so we put 3
        //x=7-4=3 we have 3 in map that mean 3+4=7

        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int rem=target-nums[i];
            if(map.containsKey(rem)){
                return new int[]{map.get(rem),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{};
    }
}
