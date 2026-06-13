class Solution {

    // class Pair{
    //     int key;
    //     int val;

    //     Pair(int key,int val){
    //         this.key=key;
    //         this.val=val;
    //     }

    //     public int getKey(){
    //         return this.key;
    //     }
    //     public int getVal(){
    //         return this.val;
    //     }
    // }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<double[]> minHeap=new PriorityQueue<>(Comparator.comparing(a->a[0]));
        // Map<Double,List<int[]>> distanceMap=new HashMap<>();

        for(int[] point:points){
            double euclidsDist=Math.sqrt(Math.pow(Math.abs(point[0]-0),2)+Math.pow(Math.abs(point[1]-0),2));
            // System.out.println("whats the distance : "+euclidsDist);
            minHeap.offer(new double[]{euclidsDist,point[0],point[1]});
            //  System.out.println("whats the minHeap : "+minHeap.toString());
            // distanceMap.put(euclidsDist,new Pair<>(point[0],point[1]));
            // if(distanceMap.containsKey(euclidsDist)){
            //     List<int[]> result=new ArrayList<>(distanceMap.get(euclidsDist));
            //     // result=distanceMap.get(euclidsDist);
            //     result.add(point);
            //     distanceMap.put(euclidsDist,result);
            // }
            // else{
            //     distanceMap.put(euclidsDist,List.of(point));
            // }
        }
        // System.out.println("whats the min distance "+minHeap.peek());
        // int size=distanceMap.get(minHeap.peek()).size();
        // List<int[]> list=distanceMap.get(minHeap.poll());
        
        // int[][] result=new int[size][size];
        // for(int i=0;i<size;i++){
        //     int[] point=list.get(i);
        //     result[i]=new int[]{point[0],point[1]};
        // }

        int[][] result=new int[k][2];
        for(int i=0;i<k;i++){
            double[] point=minHeap.poll();
            result[i]=new int[]{(int)point[1],(int)point[2]};
        }
        return result;
    }
}
