class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return slidingWindo(nums, k)-slidingWindo(nums, k-1);
    }

    public int slidingWindo(int[] nums, int k) {
        int begIndex = 0, endIndex = 0, length = nums.length;
        int totalCount = 0;

        Map<Integer, Integer> map = new HashMap<>();

        while (endIndex < length) {
            int val = nums[endIndex++];
            map.put(val, map.getOrDefault(val, 0)+1);
            while (map.size() > k) {
                int remove = nums[begIndex++];
                map.put(remove, map.get(remove)-1);
                if (map.get(remove) == 0) {
                    map.remove(remove);
                }
            }
            totalCount += (endIndex-begIndex);
        }

        return totalCount;
    }
}