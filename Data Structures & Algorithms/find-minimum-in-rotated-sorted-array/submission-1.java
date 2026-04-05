class Solution {
    //here we apply the rule of dividing and finding
    //the segment where the min can exist 
    //once we do we know that this array was sorted once
    //so the left most will be the smallest element 
    //in the right most segment hence we return nums[l]
    public int findMin(int[] nums) {
        int low=0;
        int high=nums.length-1;
        while(low<high){
            int mid=low+(high-low)/2;
            if(nums[mid]>nums[high]){
                low=mid+1;
            }
            else{
                high=mid;
            }
        }
        return nums[low];
    }
}
