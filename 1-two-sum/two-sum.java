class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mapping = new HashMap<>();
        int[] solution = new int[2];

        for (int index = 0; index < nums.length; index++) {
            int currentNum = nums[index], diff = target-currentNum;

            if (mapping.get(diff) != null) {
                solution[0] = mapping.get(diff);
                solution[1] = index;
                break;
            }

            mapping.put(currentNum, index);
        }
        
        return solution;
    }
}