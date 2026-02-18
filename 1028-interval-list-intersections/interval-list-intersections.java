class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> solution = new ArrayList<>();

        int firstIndex = 0, secondIndex = 0, firstLength = firstList.length, secondLength = secondList.length;

        while (firstIndex < firstLength && secondIndex < secondLength) {
            int firstStart = firstList[firstIndex][0], firstEnd = firstList[firstIndex][1];
            int secondStart = secondList[secondIndex][0], secondEnd = secondList[secondIndex][1];

            int start = Math.max(firstStart, secondStart);
            int end = Math.min(firstEnd, secondEnd);

            if (start <= end) {
                solution.add(new int[]{start, end});
            }

            if (firstEnd < secondEnd) {
                firstIndex++;
            } else {
                secondIndex++;
            }
        }


        return solution.toArray(new int[solution.size()][]);
    }
}