class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        int[] diff = new int[length];

        for (int index = 0; index < length; index++) {
            diff[index] = gas[index]-cost[index];
        }
        
        int leftSum = 0, rightSum = 0, startIndex = 0;

        for (int index = 0; index < length; index++) {
            rightSum += diff[index];
            if (rightSum < 0) {
                startIndex = index+1;
                leftSum += rightSum;
                rightSum = 0;
            }
        }

        return leftSum+rightSum >= 0 ? startIndex : -1;
    }
}