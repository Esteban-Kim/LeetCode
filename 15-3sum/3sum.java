class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> solution = new ArrayList<>();

        Arrays.sort(nums);
        Set<Integer> used = new HashSet<>();

        for (int index = 0; index < nums.length; index++) {
            if(!used.contains(nums[index])) {
                twoSum(nums, nums[index], index+1, solution);
            }
            used.add(nums[index]);
        }

        return solution;
    }

    public void twoSum(int[] nums, int sum, int begIndex, List<List<Integer>> solution) {
        int length = nums.length, endIndex = length-1;
        Set<List<Integer>> tempSet = new HashSet<>();

        while (begIndex < endIndex) {
            int totalSum = sum + nums[begIndex] + nums[endIndex];

            if (totalSum == 0) {
                List<Integer> tempList = new ArrayList<>();
                tempList.add(sum);
                tempList.add(nums[begIndex]);
                tempList.add(nums[endIndex]);
                solution.add(tempList);
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

        solution.addAll(tempSet);
    }
}