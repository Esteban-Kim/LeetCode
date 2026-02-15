class MedianFinder {
    private PriorityQueue<Integer> low;
    private PriorityQueue<Integer> high;

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
        int size = low.size()+high.size();
        if (size%2 == 0) {
            double total = low.peek()+high.peek();
            return total/2;
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