class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, (a,b) -> a[0]-b[0]);
        Arrays.sort(slots2, (a,b) -> a[0]-b[0]);
        
        int slots1Index = 0, slots2Index = 0;

        while (slots1Index < slots1.length && slots2Index < slots2.length) {
            int startIntersection = Math.max(slots1[slots1Index][0], slots2[slots2Index][0]);
            int endIntersection = Math.min(slots1[slots1Index][1], slots2[slots2Index][1]);

            if (endIntersection-startIntersection >= duration) {
                return Arrays.asList(startIntersection, startIntersection+duration);
            }

            if (slots2[slots2Index][1] < slots1[slots1Index][1]) {
                slots2Index++;
            } else {
                slots1Index++;
            }
        }

        return new ArrayList<>();
    }
}