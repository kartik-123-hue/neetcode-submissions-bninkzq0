class Solution {
    public boolean isPerfectSquare(int num) {
        System.out.println("what should sqr"+Math.sqrt(num));
        long start=0;
        long end=num;
        while(start<=end){
            long mid=start+(end-start)/2;
            if((long)mid*mid==(long)num){
                return true;
            }
            if(mid*mid>num){
                end=(long)mid-1;
            }
            else{
                start=(long)mid+1;
            }
        }
        return false;
    }
}