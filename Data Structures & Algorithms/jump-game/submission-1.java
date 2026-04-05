class Solution {
    public boolean canJump(int[] nums) {
        //[1,2,0,1,0]
        //4 is the goal
        //how can we reach from the last index?
        //3+1>=4
        //goal =3  everytime a new goal is set  
        //0+2>=3?no 
        //2+1>=3?yes 
        //goal 1 everytime a new goal is set  
        //1+0>=1?yes
        //goal =0; everytime a new goal is set  
        int goal=nums.length-1;
        for(int i=nums.length-2;i>=0;i--){
            if(i+nums[i]>=goal){
                goal=i;
            }
        }
        return goal==0;
    }
}
