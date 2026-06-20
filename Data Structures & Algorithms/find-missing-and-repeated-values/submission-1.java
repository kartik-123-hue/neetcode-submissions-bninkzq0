class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        double n=Math.pow(grid.length,2);
        int sum=(int)n*((int)n+1)/2;
        System.out.println(sum);
        int repeated=-1;
        int missing=-1;
        int[] hashTable=new int[(int)(n*n)];
        for(int[] arr:grid){
            for(int i:arr){
                if(hashTable[i]!=0){
                    repeated=i;
                    continue;
                }
                hashTable[i]++;
                sum-=i;
            }
        }
        return new int[] {repeated,sum};
    }
}