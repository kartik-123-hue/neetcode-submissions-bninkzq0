class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> tracker=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int need=target-nums[i];
            if( !tracker.isEmpty() && tracker.containsKey(need)){
                return new int[]{tracker.get(need),i};
            }
            tracker.put(nums[i],i);
        }
        return new int[]{};

    }
}
