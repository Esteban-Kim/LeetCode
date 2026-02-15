class MedianFinder {
    private PriorityQueue<Integer> low;
    private PriorityQueue<Integer> high;

    public MedianFinder() {
        this.low = new PriorityQueue<>((a, b) -> a-b);
        this.high = new PriorityQueue<>((a, b) -> b-a);
    }
    
    public void addNum(int num) {
        low.add(num);
        high.add(low.poll());
        if (low.size() < high.size()) {
            low.add(high.poll());
        }
    }
    
    public double findMedian() {
        // System.out.println(low.size() + " " + high.size());
        int total = low.size() + high.size();
        if (total % 2 == 0) {
            double answer = low.peek()+high.peek();
            // System.out.println(answer);
            return ((double)answer/(double)2.0);
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