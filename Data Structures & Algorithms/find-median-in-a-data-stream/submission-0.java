class MedianFinder {
    PriorityQueue<Integer> smallHeap;
    PriorityQueue<Integer> largeHeap;

    public MedianFinder() {
        smallHeap=new PriorityQueue<>(Collections.reverseOrder());
        largeHeap=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(smallHeap.isEmpty() || num<=smallHeap.peek()){
            smallHeap.offer(num);
        }
        else{
            largeHeap.offer(num);
        }

        //rebalance 
        //if two halves of the tree
        //is one is larger than the other then shift to lower tree if 
        //satisfying the condition
        if(smallHeap.size()>largeHeap.size()+1){
            largeHeap.offer(smallHeap.poll());
        }
        else if (largeHeap.size()>smallHeap.size()){
            smallHeap.offer(largeHeap.poll());
        }
    }
    
    public double findMedian() {
        if(smallHeap.size()>largeHeap.size()){
            return smallHeap.peek();
        }
        return (double) (smallHeap.peek()+largeHeap.peek())/2;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */