class Solution {
    public int[] twoSum(int[] numbers, int target) {
        /*
        the solutions needs to have no extra space
        
        so if use the 2 sum (non sorted ) we will have a map that will
        store the prev a and compare with b-target

        we do a two pointer method
        why?
        o(n) and o(1)space no extra space

        the idea is to keep a left and right pointer at either ends
        and brind them closure but comparing their sum with target
        [1,2,3,4]
        l=1 and right 4
        sum=1+4 = 5
        5>3 that means we need to reduce the sum so we need to go the array (as it its sorted) r--
        1+3=4>3 we do the same thing
        1+2==3 not more than target not less equal
        so we give the index by increment 1
        
        */

        int l=0;
        int r=numbers.length-1;
        while(l<r){
            int sum=numbers[l]+numbers[r];
             if(sum<target){
                l++;
            }
            else if(sum>target){
                r--;
            }
            else{
                return new int[]{l+1,r+1};
            }
        }
        return new int[]{};
    }
}
