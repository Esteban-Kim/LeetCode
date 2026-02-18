class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> leftSum = new HashMap<>();
        leftSum.put(0, 1);

        int runningSum = 0;
        int count = 0;

        for (int num : nums) {
            runningSum += num;
            if (leftSum.get(runningSum-k) != null) {
                count += leftSum.get(runningSum-k);
            }
            leftSum.put(runningSum, leftSum.getOrDefault(runningSum, 0)+1);
        }

        return count;
    }
}