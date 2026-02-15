class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> mapping = new HashMap<>();
        int[] inward = new int[numCourses];

        for (int[] prerequisite : prerequisites) {
            int start = prerequisite[1], end = prerequisite[0];
            List<Integer> list = mapping.getOrDefault(start, new ArrayList<>());
            list.add(end);
            mapping.put(start, list);
            inward[end]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int index = 0; index < numCourses; index++) {
            if (inward[index] == 0) {
                queue.add(index);
            }
        }

        int[] answer = new int[numCourses];
        int index = 0;

        while (!queue.isEmpty()) {
            int next = queue.poll();
            answer[index++] = next;
            List<Integer> list = mapping.getOrDefault(next, new ArrayList<>());
            for (int val : list) {
                inward[val]--;
                if (inward[val] == 0) {
                    queue.add(val);
                }
            }
        }

        if (index == numCourses) {
            return answer;
        }

        return new int[0];
    }
}