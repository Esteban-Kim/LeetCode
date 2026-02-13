class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0, length = nums.length, sum = 0;
        Map<Integer, Integer> possibilities = new HashMap<>();
        possibilities.put(0, 1);

        for (int index = 0; index < length; index++) {
            sum += nums[index];
            if (possibilities.containsKey(sum-k)) {
                count += possibilities.get(sum-k);
            }
            possibilities.put(sum, possibilities.getOrDefault(sum, 0)+1);
        }

        return count;
    }
}