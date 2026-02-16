class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> intersections = new ArrayList<>();

        int firstIndex = 0, secondIndex = 0, firstLength = firstList.length, secondLength = secondList.length;

        while (firstIndex < firstLength && secondIndex < secondLength) {
            int firstStart = firstList[firstIndex][0], firstEnd = firstList[firstIndex][1];
            int secondStart = secondList[secondIndex][0], secondEnd = secondList[secondIndex][1];

            int maxStart = Math.max(firstStart, secondStart);
            int minEnd = Math.min(firstEnd, secondEnd);

            if (maxStart <= minEnd) {
                intersections.add(new int[]{maxStart, minEnd});
            }

            if (firstEnd < secondEnd) {
                firstIndex++;
            } else {
                secondIndex++;
            }
        }

        return intersections.toArray(new int[intersections.size()][]);
    }
}