class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> threeSums = new ArrayList<>();
        Set<Integer> available = new HashSet<>();

        for (int index = 0; index < nums.length; index++) {
            int num = nums[index];
            if (!available.contains(num)) {
                distinctTwoSum(nums, index+1, num, threeSums);
            }
            available.add(num);
        }

        return threeSums;
    }

    public void distinctTwoSum(int[] nums, int index, int firstValue, List<List<Integer>> threeSums) {
        int length = nums.length, begIndex = index, endIndex = length-1;

        while (begIndex < endIndex) {
            int totalSum = firstValue + nums[begIndex] + nums[endIndex];
            // System.out.println(firstValue + " " + nums[begIndex] + " " + nums[endIndex] + " " + totalSum);
            if (totalSum == 0) {
                threeSums.add(Arrays.asList(firstValue, nums[begIndex], nums[endIndex]));
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
                while (endIndex > begIndex && nums[endIndex] == nums[endIndex+1]) {
                    endIndex--;
                }
            }
        }
    }
}