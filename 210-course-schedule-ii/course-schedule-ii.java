class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        int[] inwardEdges = new int[numCourses];

        for (int[] prereq : prerequisites) {
            int start = prereq[1], end = prereq[0];
            inwardEdges[end]++;
            Queue<Integer> tempQueue = map.getOrDefault(start, new LinkedList<>());
            tempQueue.add(end);
            map.put(start, tempQueue);
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] solution = new int[numCourses];
        int solutionIndex = 0;

        for (int index = 0; index < numCourses; index++) {
            if (inwardEdges[index] == 0) {
                queue.add(index);
            }
        }

        while (!queue.isEmpty()) {
            int course = queue.poll();
            solution[solutionIndex++] = course;
            Queue<Integer> tempQueue = map.getOrDefault(course, new LinkedList<>());
            while (!tempQueue.isEmpty()) {
                int next = tempQueue.poll();
                inwardEdges[next]--;
                if (inwardEdges[next] == 0) {
                    queue.add(next);
                }
            }
        }

        if (solutionIndex == numCourses) {
            return solution;
        }

        return new int[0];
    }
}