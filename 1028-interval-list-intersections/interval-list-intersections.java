class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> intersections = new ArrayList<>();

        int fIndex = 0, fLength = firstList.length, sIndex = 0, sLength = secondList.length;

        while (fIndex < fLength && sIndex < sLength) {
            int fStart = firstList[fIndex][0], fEnd = firstList[fIndex][1];
            int sStart = secondList[sIndex][0], sEnd = secondList[sIndex][1];

            int startIntersection = Math.max(fStart, sStart), endIntersection = Math.min(fEnd, sEnd);

            if (endIntersection >= startIntersection) {
                intersections.add(new int[]{startIntersection, endIntersection});
            }

            if (fEnd < sEnd) {
                fIndex++;
            } else {
                sIndex++;
            }
        }

        return intersections.toArray(new int[intersections.size()][]);
    }
}