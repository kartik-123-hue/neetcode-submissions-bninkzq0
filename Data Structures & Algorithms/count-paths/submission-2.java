class Solution {
    int[][] memo;
    public int uniquePaths(int m, int n) {
        memo=new int[m][n];
        for(int[] row:memo){
            Arrays.fill(row,-1);
        }
        return dfs(0,0,m,n);
    }

    public int dfs(int i,int j,int m,int n){
        if(i==m-1 && j==n-1){
            return 1;
        }
        if(i>=m || j>=n){
            return 0;
        }
        if(memo[i][j]!=-1){
            return memo[i][j];
        }
        //number of ways
        //it will first go all right
        //then it will go down
        

        //the thing we are repeating paths which we have already calculation

        //we will keep a memory map
        int max=dfs(i,j+1,m,n)+dfs(i+1,j,m,n);
        memo[i][j]=max;
        return max;
    }
}
