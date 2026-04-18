class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] newArray=new int[nums1.length+nums2.length];
        int i=0;
        for(int n:nums1){
            newArray[i++]=n;
        }
        for(int n:nums2){
            newArray[i++]=n;
        }
        Arrays.sort(newArray);
        int mid=(0+newArray.length-1)/2;
        // System.out.println(("the double "+((double)(newArray[mid]+newArray[mid+1])/2)));
        return  newArray.length%2==0?(double)(newArray[mid]+newArray[mid+1])/2:newArray[mid];
    }
}
