class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result=new ArrayList<>();
        int i=0;
        //add all intervals which come before the new interval
        //[[1,2],[3,5],[9,10]] old [6,7] new
        //1,2 2<6
        //result[[1,2]] i=1
        //3,5 5<6
        //result [[1,2][3,5]] i=2
        //9,10 10<6 break; 
        for(int[] interval:intervals){
            if(interval[1]>=newInterval[0]){
                break;
            }
            result.add(interval);
            i++;
        }

        //we have found an interval which overlaps 6,7 that is 9,10
        //min of start and max of end
        while(i<intervals.length && newInterval[1]>=intervals[i][0]){
            newInterval[0]=Math.min(newInterval[0],intervals[i][0]);
            newInterval[1]=Math.max(newInterval[1],intervals[i][1]);
            i++;
        }
        result.add(newInterval);
        while(i<intervals.length){
            result.add(intervals[i]);
            i++;
        }
        return result.toArray(new int[result.size()][]);
    
    }
}
