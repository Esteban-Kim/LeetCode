class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> distinctThreeSums = new ArrayList<>();
        Set<Integer> usedNums = new HashSet<>();

        Arrays.sort(nums);

        for (int index = 0; index < nums.length; index++) {
            if (!usedNums.contains(nums[index])) {
                twoSum(nums, index+1, nums[index], distinctThreeSums);
            }
            usedNums.add(nums[index]);
        }

        return distinctThreeSums;
    }

    public void twoSum(int[] nums, int index, int sum, List<List<Integer>> distinctThreeSums) {
        int begIndex = index, endIndex = nums.length-1;

        while (begIndex < endIndex) {
            int totalSum = sum + nums[begIndex] + nums[endIndex];

            if (totalSum == 0) {
                distinctThreeSums.add(Arrays.asList(sum, nums[begIndex], nums[endIndex]));
                begIndex++;
                while (begIndex < endIndex && nums[begIndex] == nums[begIndex-1]) {
                    begIndex++;
                }
            } else if (totalSum < 0) {
                begIndex++;
                while (begIndex < endIndex && nums[begIndex] == nums[begIndex-1]) {
                    begIndex++;
                }
            } else {
                endIndex--;
                while (begIndex < endIndex && nums[endIndex] == nums[endIndex+1]) {
                    endIndex--;
                }
            }
        }
    }
}