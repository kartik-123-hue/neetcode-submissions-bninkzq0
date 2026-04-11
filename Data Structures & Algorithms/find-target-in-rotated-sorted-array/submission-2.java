class Solution {
    public int search(int[] nums, int target) {
        //find pivot index of the low segments
        //and high segment 
        //find the target in that in segment
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
        int pivot=low;
        int result=binSearch(nums,0,pivot-1,target);
        return result!=-1?result:binSearch(nums,pivot,nums.length-1,target);
    }

    public int binSearch(int[] nums,int low,int high,int target){
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(target<nums[mid]){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return -1;
    }
}
