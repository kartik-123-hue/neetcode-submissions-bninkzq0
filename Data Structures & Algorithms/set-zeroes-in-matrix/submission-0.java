class Solution {
    public void setZeroes(int[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;

        boolean[] rowZero=new boolean[row];
        boolean[] colZero=new boolean[col];

        for(int r=0;r<row;r++){
            for(int c=0;c<col;c++){
                if(matrix[r][c]==0){
                    rowZero[r]=true;
                    colZero[c]=true;
                }
            }
        }

        for(int r=0;r<row;r++){
            for(int c=0;c<col;c++){
                if(rowZero[r] || colZero[c]){
                    matrix[r][c]=0;
                }
            }
        }
        
    }
}
