class Solution {
    public int divisibleTripletCount(int[] nums, int d) {
        Map<Integer, Integer> frequency = new HashMap<>();
        int count = 0, length = nums.length;

        if (length < 3) {
            return count;
        }
        int a = 0, b = 0;
        for (int i = length-3; i >= 0; i--) {
            a = i+1;
            b = length-1;
            while (a < b) {
                int total = (nums[a]+nums[b])%d;
                frequency.put(total, frequency.getOrDefault(total, 0)+1);
                b--;
            }
            for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
                if ((entry.getKey()+nums[i]) % d == 0) {
                    count += entry.getValue();
                }
            }
        }


        return count;
    }
}