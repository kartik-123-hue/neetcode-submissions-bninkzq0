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
    public int minMeetingRooms(List<Interval> intervals) {
            TreeMap<Integer,Integer> map=new TreeMap<>();
            for(Interval interval:intervals){
                map.put(interval.start,map.getOrDefault(interval.start,0)+1);
                map.put(interval.end,map.getOrDefault(interval.end,0)-1);
            }

            int active=0;
            int res=0;
            for(int i:map.keySet()){
                active+=map.get(i);
                res=Math.max(active,res);
            }
            return res;
    }
}
