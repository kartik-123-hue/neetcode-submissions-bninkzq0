class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        if(n>m){
            return findMedianSortedArrays(nums2,nums1);
        }
        int low=0;
        int high=n;
        while(low<=high){
            int px=(low+high)/2;
            int py=((n+m+1)/2)-px;
            int ALeft=px==0?Integer.MIN_VALUE:nums1[px-1];//maxLeftX
            int ARight=px==n?Integer.MAX_VALUE:nums1[px];//minRightX
            int BLeft=py==0?Integer.MIN_VALUE:nums2[py-1];//maxLeftY
            int BRight=py==m?Integer.MAX_VALUE:nums2[py];//minRightY
            if(ALeft<=BRight && BLeft<=ARight){
                if((m+n)%2==0){
                    return (double)(Math.max(ALeft,BLeft)+Math.min(ARight,BRight))/2;
                }
                else{
                    return Math.max(ALeft,BLeft);
                }
            }
            else if (ALeft>BRight){
                high=px-1;
            }
            else{
                low=px+1;
            }
        }
        return -1;
    }
}
