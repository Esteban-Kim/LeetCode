class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Queue<Integer>> prerequisiteMap = new HashMap<>();
        int[] totalPrerequisites = new int[numCourses];

        for (int[] prerequisite : prerequisites) {
            int start = prerequisite[1], end = prerequisite[0];
            totalPrerequisites[end]++;
            Queue<Integer> tempQueue = prerequisiteMap.getOrDefault(start, new LinkedList<>());
            tempQueue.add(end);
            prerequisiteMap.put(start, tempQueue);
        }

        Queue<Integer> nonPrerequisiteCourses = new LinkedList<>();

        for (int index = 0; index < numCourses; index++) {
            if (totalPrerequisites[index] == 0) {
                nonPrerequisiteCourses.add(index);
            }
        }

        int[] courseOrder = new int[numCourses];
        int courseOrderIndex = 0;

        while (!nonPrerequisiteCourses.isEmpty()) {
            int addCourse = nonPrerequisiteCourses.poll();
            courseOrder[courseOrderIndex++] = addCourse;
            Queue<Integer> removeList = prerequisiteMap.getOrDefault(addCourse, new LinkedList<>());
            while (!removeList.isEmpty()) {
                int removeCourse = removeList.poll();
                totalPrerequisites[removeCourse]--;
                if (totalPrerequisites[removeCourse] == 0) {
                    nonPrerequisiteCourses.add(removeCourse);
                }
            }
        }

        if (courseOrderIndex == numCourses) {
            return courseOrder;
        }

        return new int[0];
    }
}