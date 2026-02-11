class Solution {
    public int findShortestSubArray(int[] nums) {
        int maxFrequency = 0, length = nums.length;

        Map<Integer, Integer> frequency = new HashMap<>();
        Map<Integer, Degree> memory = new HashMap<>();

        for (int index = 0; index < length; index++) {
            int num = nums[index];

            frequency.put(num, frequency.getOrDefault(num, 0)+1);
            
            Degree degree = memory.get(num);
            if (degree == null) {
                degree = new Degree(index, index);
            } else {
                degree.endIndex = index;
            }
            memory.put(num, degree);

            maxFrequency = Math.max(maxFrequency, frequency.get(num));
        }

        int minDegree = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            if (entry.getValue() == maxFrequency) {
                Degree degree = memory.get(entry.getKey());
                minDegree = Math.min(minDegree, degree.endIndex-degree.startIndex+1);
            }
        }
        
        return minDegree;
    }
}

class Degree {
    int startIndex = Integer.MIN_VALUE;
    int endIndex = Integer.MAX_VALUE;

    public Degree(int startIndex, int endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }
}