/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {

    //what i understand 
    // [(0,30),(5,10),(15,20)]
    //the person has a meeting from 0,30
    //and the next meeting which he has from 5,10 and thats contradiction 
    //it is with current meeting range
    //-----------------------------------------------
    //0    5     10                                    30

    public boolean canAttendMeetings(List<Interval> intervals) {
        // if(intervals.size()==0){
        //     return true;
        // }
        // int max=intervals.get(0).end;
    
        // for(int i=1;i<intervals.size()-1;i++){
        //     if(intervals.get(i).start<max){
        //         return false;
        //     }
        //    max=intervals.get(i).end;
        //    System.out.println( "max : "+max);
        // }
        // return true;

        Collections.sort(intervals,Comparator.comparingInt(i->i.start));
        for(int i=1;i<intervals.size();i++){
            Interval i1=intervals.get(i-1);
            Interval i2=intervals.get(i);
            if(i1.end>i2.start){
                return false;
            }
        }
        return true;
    }
}
