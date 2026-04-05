class Solution {
    public int[][] merge(int[][] intervals) {
        //[1,3][1,5] are overlapping as they have the same start point hence [1,5]
        //[1,2][2,3] are overlapping they have the same end and start time [1,3]
        //[1,3][2,3] are overlapping they have the same end time hence [1,3]
        Arrays.sort(intervals, (x, y) -> Integer.compare(x[0],y[0]));  
        List<int[]> processIntervals=new ArrayList<>();
        processIntervals.add(intervals[0]);
        // int i=0;
        // for(int[] interval:intervals){
        //     // if(interval[1]>=interval[0]){
        //     //     break;
        //     // }
        //     processIntervals.add(interval);
        //     // i++;
        // }
        // while(i<intervals.length && intervals[i][1]>=intervals[i-1][0]){

        //     intervals[i][0]=Math.min(intervals[i][0],intervals[i-1][0]);
        //     intervals[i][1]=Math.max(intervals[i][1],intervals[i-1][1]);
        //     i++;
        //     processIntervals.add(intervals[i]);
        // }
        for(int[] interval:intervals){
            int start=interval[0];
            int end=interval[1];
            int prevEnd=processIntervals.get(processIntervals.size()-1)[1];
            if(prevEnd>=start){
                processIntervals.get(processIntervals.size()-1)[1]=Math.max(end,prevEnd);
            }
            else{
                processIntervals.add(new int[]{start,end});
            }
           
        }
        return processIntervals.toArray(new int[processIntervals.size()][]);
    }
}
