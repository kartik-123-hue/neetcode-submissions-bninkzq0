class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int min=0;
        Arrays.sort(intervals,(x,y)->Integer.compare(x[0],y[0]));
        int prevEnd=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            int start=intervals[i][0];
            int end=intervals[i][1];
            if(prevEnd>start){
                prevEnd=Math.min(prevEnd,end);
                min++;
            }
            else{
                prevEnd=end;
            }
        }
        return min;
    }
}
