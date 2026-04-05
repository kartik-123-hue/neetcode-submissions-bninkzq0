class Solution {
    public int getSum(int a, int b) {
        // int carry=0;
        // int res=0;

        // for(int i=0;i<32;i++){
        //     int a_bit=a>>i & 1;
        //     int b_bit=b>>i & 1;
        //     int curr_bit=a_bit ^ b_bit ^ carry;
        //     carry= (a_bit+b_bit+carry)>=2?1:0;
        //     if(curr_bit!=0){
        //         res|=(1<<i);
        //     }
        // }
        // return res;

        while(b!=0){
            
            int carry=(a&b)<<1;
            
            a^=b;
            b=carry;
        }
        return a;
    }
}
