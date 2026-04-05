class Solution {
    //here we are searching for pivot index
    //and dividing the array 
    //into two and then perform search using bin search
    //anyways O(logn)(left half) +O(logn)(right half) will still mean O(logn)
    public int search(int[] nums, int target) {
        int l=0;
        int r=nums.length-1;
        while(l<r){
            int mid=l+(r-l)/2;
            if(nums[mid]>nums[r]){
                l=mid+1;
            }
            else{
                r=mid;
            }
        }
        int pivot=l;
        int result=binarySearch(nums,target,0,pivot-1);
        return result!=-1 ? result:binarySearch(nums,target,pivot,nums.length-1);
    }
    public int binarySearch(int[] nums,int target,int l,int r){
        while(l<=r){
            int mid=l+(r-l)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if (nums[mid]>target){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return -1;
    }
}
