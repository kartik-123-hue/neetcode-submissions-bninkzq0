class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length==0){
            return new int[][] {newInterval};
        }

        int left=0,right=intervals.length-1;
        
        while(left<=right){
            int mid=left+(right-left)/2;
            //the below condition is checking
            //all the intervals coming before the newIntervals
            //start time
            if(intervals[mid][0]<newInterval[0]){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }

        List<int[]> sortedArray=new ArrayList<>();
        for(int i=0;i<left;i++){
            //adding in sort all intervals before the newInterval
            sortedArray.add(intervals[i]);
        }
        sortedArray.add(newInterval);
        for(int i=left;i<intervals.length;i++){
            //after the new interval is added the intervals that are 
            //left in the array
            sortedArray.add(intervals[i]);
        }

        List<int[]> merged=new ArrayList<>();
        for(int[] interval:sortedArray){
            if(merged.isEmpty() || merged.get(merged.size()-1)[1]<interval[0]){
                //if no overlapp is found then we add the interval in order
                merged.add(interval);
            }
            else{
                // if overlap is found then we extend the max
                merged.get(merged.size()-1)[1]=Math.max(merged.get(merged.size()-1)[1],interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()-1][]);
    }
}
