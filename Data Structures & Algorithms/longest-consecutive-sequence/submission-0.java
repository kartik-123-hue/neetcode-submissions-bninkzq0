class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int n:nums){
            set.add(n);
        }
        int max=0;
        for(int n:set){
            if(!set.contains(n-1)){
               int length=1;
               int ele=n+1;
               while(set.contains(ele)){
                    length++;
                    ele++;
               }
               max=Math.max(max,length);
            }
        }
        return max;
    }
}
