class Solution {
    public int hammingWeight(int n) {
        // we need to return the number of 1's from n
        //n is 32 bit number
        //so we can to string manipulation we we can but that o(n)
        
        //bit manipulation
        //we have 
        //1<<i left shit here(hamming weights and population count)
        //1*2^0 00000000000000000000000000000001 & 00000000000000000000000000010111 
        //AND operator
        // 0 0 0
        // 0 1 0
        // 1 0 0
        // 1 1 1

        int res=0;
        for(int i=0;i<32;i++){
            if((1<<i & n)!=0){
                res++;
            }
        }   
        return res;
    }
}
