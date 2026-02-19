class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<>((a, b) -> a-b);

        for (int num : nums) {
            pQueue.add(num);
            if (pQueue.size() > k) {
                pQueue.poll();
            }
        }

        return pQueue.peek();
    }
}