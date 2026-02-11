class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int length = nums.length, startIndex = 0, endIndex = length-1;

        while (startIndex < endIndex) {
            while (startIndex < length && nums[startIndex] % 2 == 0) {
                startIndex++;
            }
            while (endIndex >= 0 && nums[endIndex] % 2 == 1) {
                endIndex--;
            }

            if (startIndex < endIndex) {
                int saveFirst = nums[startIndex];
                nums[startIndex] = nums[endIndex];
                nums[endIndex] = saveFirst;
            }
        }

        return nums;
    }
}