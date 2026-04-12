class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROWS=matrix.length;
        int COLS=matrix[0].length;
        int top=0;
        int bottom=ROWS-1;
        while(top<=bottom){
            int row=(top+bottom)/2;
            if(target>matrix[row][COLS-1]){
                top=row+1;
            }
            else if(target<matrix[row][0]){
                bottom=row-1;
            }
            else{
                break;
            }
        }
        if(!(top<=bottom)){
            return false;
        }
        int l=0;
        int r=COLS-1;
        int row=(top+bottom)/2;

        while(l<=r){
            int mid=l+(r-l)/2;
            if(matrix[row][mid]==target){
                return true;
            }
            else if (target<matrix[row][mid]){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return false;
    }
}
