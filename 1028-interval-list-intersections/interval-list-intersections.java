class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int firstIndex = 0, firstLength = firstList.length, secondIndex = 0, secondLength = secondList.length;

        List<int[]> solution = new ArrayList<>();

        while (firstIndex < firstLength && secondIndex < secondLength) {
            int startIntersection = Math.max(firstList[firstIndex][0], secondList[secondIndex][0]);
            int endIntersection = Math.min(firstList[firstIndex][1], secondList[secondIndex][1]);

            if (endIntersection-startIntersection >= 0) {
                solution.add(new int[]{startIntersection, endIntersection});
            }

            if (secondList[secondIndex][1] < firstList[firstIndex][1]) {
                secondIndex++;
            } else {
                firstIndex++;
            }
        }

        int[][] answer = new int[solution.size()][2];
        for (int index = 0; index < solution.size(); index++) {
            answer[index] = solution.get(index);
        }
        return answer;
    }
}