class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
    
        int length = nums.length;
        boolean[] used = new boolean[length];

        createPermutations(nums, new ArrayList<>(), permutations, used);

        return permutations;
    }

    public void createPermutations(int[] nums, List<Integer> list, List<List<Integer>> permutations, boolean[] used) {
        int length = nums.length;

        if (list.size() == length) {
            permutations.add(list);
            return;
        }

        for (int index = 0; index < length; index++) {
            if (!used[index]) {
                used[index] = true;
                List<Integer> copy = new ArrayList<>(list);
                copy.add(nums[index]);
                createPermutations(nums, copy, permutations, used);
                used[index] = false;
            }
        }

    }
}