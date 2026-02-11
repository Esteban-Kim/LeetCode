class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        
        for (int num : nums) {
            pQueue.add(num);
            if (pQueue.size() > k) {
                pQueue.poll();
            }
        }

        return pQueue.poll();
    }
}