class Solution {
    public int[] twoSum(int[] nums, int target) {
        //nums[i]+nums[j]=target;
        //nums[i]=target-nums[j];

        //3,4,5,6 target=7;
        //7-3=4  store 
        //7-4=3 store
        HashMap<Integer,Integer> map=new HashMap<>(); 
        for(int i=0;i<nums.length;i++){
            int difference=target-nums[i];
            if(map.containsKey(difference)){
                return new int[]{map.get(difference),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{};
    }
}
