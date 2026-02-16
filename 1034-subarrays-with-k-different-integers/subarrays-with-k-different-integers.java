class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return subarrays(nums, k) - subarrays(nums, k-1);
    }

    public int subarrays(int[] nums, int k) {
        int left = 0, right = 0, length = nums.length, total = 0;
        Map<Integer, Integer> frequency = new HashMap<>();

        while (right < length) {
            int num = nums[right++];
            frequency.put(num, frequency.getOrDefault(num, 0)+1);
            while (frequency.size() > k) {
                int remove = nums[left++];
                frequency.put(remove, frequency.get(remove)-1);
                if (frequency.get(remove) == 0) {
                    frequency.remove(remove);
                }
            }
            total += (right-left);
        }

        return total;
    }
}