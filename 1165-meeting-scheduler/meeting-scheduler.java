class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, (a, b) -> a[0]-b[0]);
        Arrays.sort(slots2, (a, b) -> a[0]-b[0]);
        
        int s1Index = 0, s1Length = slots1.length, s2Index = 0, s2Length = slots2.length;

        while (s1Index < s1Length && s2Index < s2Length) {
            int s1Start = slots1[s1Index][0], s1End = slots1[s1Index][1];
            int s2Start = slots2[s2Index][0], s2End = slots2[s2Index][1];

            int startIntersection = Math.max(s1Start, s2Start), endIntersection = Math.min(s1End, s2End);

            if (endIntersection-startIntersection >= duration) {
                return Arrays.asList(startIntersection, startIntersection+duration);
            }

            if (s1End < s2End) {
                s1Index++;
            } else {
                s2Index++;
            }
        }

        return new ArrayList<>();
    }
}