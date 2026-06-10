class MedianFinder {
    PriorityQueue<Integer> smallHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        smallHeap=new PriorityQueue<>(Collections.reverseOrder());
        maxHeap=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(smallHeap.isEmpty() || num<=smallHeap.peek()){
            smallHeap.offer(num);
        }
        else{
            maxHeap.offer(num);
        }

        if(smallHeap.size()>maxHeap.size()+1){
            maxHeap.offer(smallHeap.poll());
        }
        else if (maxHeap.size()>smallHeap.size()){
            smallHeap.offer(maxHeap.poll());
        }
    }
    
    public double findMedian() {
        if(smallHeap.size()>maxHeap.size()){
            return smallHeap.peek();
        }
        return (double) (smallHeap.peek()+maxHeap.peek())/2;
    }
}
