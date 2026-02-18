class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Map<String, Boolean> visited = new HashMap<>();
        for (String word : wordList) {
            visited.put(word, false);
        }
        if (!visited.containsKey(endWord)) {
            return new ArrayList<>();
        }
        List<List<String>> levels = new ArrayList<>();
        if (!bfs(beginWord, endWord, visited, levels)) return new ArrayList<>();
        List<String> start = new ArrayList<>();
        start.add(endWord);

        List<List<String>> answer = new ArrayList<>();
        answer.add(start);

        for (int index = levels.size()-1; index >= 0; index--) {
            List<List<String>> tempAnswer = new ArrayList<>();
            List<String> level = levels.get(index);
            for (List<String> a : answer) {
                String first = a.get(0);
                for (String t : level) {
                    System.out.println(t + " " + first);
                    if (difByOne(first, t)) {
                        List<String> works = new ArrayList<>(a);
                        works.addFirst(t);
                        tempAnswer.add(works);
                    }
                }
            }
            answer = tempAnswer;
        }

        return answer;
    }

    public boolean bfs(String beginWord, String endWord, Map<String, Boolean> visited, List<List<String>> levels) {
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        visited.put(beginWord, true);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<String> level = new ArrayList<>();
            for (int index = 0; index < size; index++) {
                String next = queue.poll();
                level.add(next);
                if (next.equals(endWord)) {
                    return true;
                }
                for (Map.Entry<String, Boolean> entry : visited.entrySet()) {
                    if (!entry.getValue() && difByOne(entry.getKey(), next)) {
                        visited.put(entry.getKey(), true);
                        queue.add(entry.getKey());
                    }
                }
            }
            levels.add(level);
        }

        return false;
    }

    public boolean difByOne(String w1, String w2) {
        int count = 0;
        for (int index = 0; index < w1.length(); index++) {
            if (w1.charAt(index) != w2.charAt(index)) {
                count++;
            }
        }
        return count == 1;
    }
}