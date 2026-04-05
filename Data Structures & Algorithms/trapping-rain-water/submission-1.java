class Solution {
    public int trap(int[] height) {
        /*
        the idea is capture the max height at the left so that we can substract
        with current to know the amount of water that can be contained

        [0,2,0,3,1,0,1,3,2,1]

        lets place 
        leftMax at the left most end that is 0
        and rightMax at the right most end that is 1
        
        now if we check leftMax<rightMax 0<1 min is 0
        that mean the height of the left most water is 0 
        that means no water can be stored there

        lets push to 2 now two becomes the leftMax
        2<1? now that means rightMax does satisfy the container length

        now the max water that can stored 2-2=0 that means theres no space
        we move the rightMax to 2
        checking 2<2 this also doesnt satisfy and no water can still be stored at this position

        we move the right pointer to 3
        now 2<3 we see 2 is min and the max reached here was 2
        and at current position 2(left)
        2-0=2 2 water units can be saved
        we have 2<3
        l++ we move it 3 now the leftMax is set to 3 
        3-3 =0 now water can be store 3<3? now we right pointer
        1 but the rightMax still remains 3 
        so the 3-1=2 water unit can be stored 2+2=4
        3<3
        position of right moves to 0 
        3-0=3(at this positon 3)
        4+3=7 water units

        we move the right pointer to 1
        3<3
        3-1=3
        7+2=9

        and we check agains 3<3 but this time r++ exceeds l we brake the loop and come out

        */
        int res=0;
        int l=0;
        int r=height.length-1;
        int leftMax=height[l];
        int rightMax=height[r];
        while(l<r){
            if(leftMax<rightMax){
                l++;
                leftMax=Math.max(leftMax,height[l]);
                res+=leftMax-height[l];
            }
            else{
                r--;
                rightMax=Math.max(rightMax,height[r]);
                res+=rightMax-height[r];
            }
        }
        return res;
    }
}
