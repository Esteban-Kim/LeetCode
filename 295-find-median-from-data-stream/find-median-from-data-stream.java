class MedianFinder {
    PriorityQueue<Integer> low;
    PriorityQueue<Integer> high;

    public MedianFinder() {
        low = new PriorityQueue<>((a, b) -> a-b);
        high = new PriorityQueue<>((a, b) -> b-a);
    }
    
    public void addNum(int num) {
        low.add(num);
        high.add(low.poll());
        if (high.size() > low.size()) {
            low.add(high.poll());
        }
    }
    
    public double findMedian() {
        if ((low.size()+high.size()) % 2 == 0) {
            return (double)((low.peek()+high.peek())/2.0);
        }
        return low.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */