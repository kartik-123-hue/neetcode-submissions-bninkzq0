class Solution {
    public int[] countBits(int n) {
        int[] res=new int[n+1];
        for(int num=1;num<=n;num++){
            for(int i=0;i<32;i++){
                if(((1<<i) & num)!=0){
                    res[num]++;
                }
            }
        }
        return res;
    }
}
