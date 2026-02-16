class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> leftSum = new HashMap<>();
        leftSum.put(0, 1);
        int runningSum = 0, totalSubarrays = 0;

        for (int num : nums) {
            runningSum += num;
            int target = runningSum-k;
            if (leftSum.get(target) != null) {
                totalSubarrays += leftSum.get(target);
            }
            leftSum.put(runningSum, leftSum.getOrDefault(runningSum, 0)+1);
        }

        return totalSubarrays;
    }
}