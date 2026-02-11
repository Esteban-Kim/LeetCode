class Solution {
    public boolean canJump(int[] nums) {
        int maxIndex = nums[0];

        for (int index = 1; index < nums.length; index++) {
            if (maxIndex < index) {
                return false;
            }
            maxIndex = Math.max(maxIndex, index+nums[index]);
        
            if (maxIndex >= nums.length-1) {
                return true;
            }
        }

        return true;
    }
}