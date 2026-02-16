class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, (a, b) -> a[0]-b[0]);
        Arrays.sort(slots2, (a, b) -> a[0]-b[0]);

        int firstIndex = 0, firstLength = slots1.length, secondIndex = 0, secondLength = slots2.length;

        while (firstIndex < firstLength && secondIndex < secondLength) {
            int firstStart = slots1[firstIndex][0], firstEnd = slots1[firstIndex][1];
            int secondStart = slots2[secondIndex][0], secondEnd = slots2[secondIndex][1];

            int firstMax = Math.max(firstStart, secondStart);
            int firstMin = Math.min(firstEnd, secondEnd);

            if (firstMin-firstMax >= duration) {
                return Arrays.asList(firstMax, firstMax+duration);
            }

            if (firstEnd < secondEnd) {
                firstIndex++;
            } else {
                secondIndex++;
            }
        }
        

        return new ArrayList<>();
    }
}