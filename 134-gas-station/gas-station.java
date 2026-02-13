class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = cost.length;
        int[] sum = new int[length];

        for (int index = 0; index < length; index++) {
            sum[index] = gas[index]-cost[index];
        }

        int leftSum = 0, currentSum = 0, idealIndex = 0;

        for (int index = 0; index < length; index++) {
            currentSum += sum[index];
            if (currentSum < 0) {
                leftSum += currentSum;
                idealIndex = index+1;
                currentSum = 0;
            }
        }


        return leftSum + currentSum >= 0 ? idealIndex : -1;
    }
}