class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] kFrequent = new int[k];

        PriorityQueue<int[]> pQueue = new PriorityQueue<>((a, b) -> {
            return b[0]-a[0];
        });

        Map<Integer, Integer> frequency = new HashMap<>();

        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0)+1);
        }

        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            pQueue.add(new int[]{entry.getValue(), entry.getKey()});
        }

        for (int index = 0; index < k && !pQueue.isEmpty(); index++) {
            int[] next = pQueue.poll();
            kFrequent[index] = next[1];
        }

        return kFrequent;
    }
}