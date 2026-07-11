class Solution {
    int[] cache;
    public int climbStairs(int n) {
        this.cache=new int[n];
        for(int i=0;i<n;i++){
            cache[i]=-1;
        }
        return dfs(0,n);
    }
    public int dfs(int steps,int n){
        if(steps>=n){
            return steps==n?1:0;
        }
        if(cache[steps]!=-1){
            // total[0]++;
            // return;
            return cache[steps];
        }
        return cache[steps]=dfs(steps+1,n)+dfs(steps+2,n);
    }
}
