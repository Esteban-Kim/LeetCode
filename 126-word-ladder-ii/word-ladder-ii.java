class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Map<String, Boolean> used = new HashMap<>();
        LinkedList<List<String>> result = new LinkedList<>();
        LinkedList<List<String>> layers = new LinkedList<>();
        for (String word : wordList) {
            used.put(word, false);
        }

        if (!bfs(beginWord, endWord, used, layers)) {
            return result;
        }

        result.add(Arrays.asList(endWord));

        for (int index = layers.size()-1; index >= 0; index--) {
            List<String> current = layers.get(index);
            int size = result.size();
            while (size-- > 0) {
                List<String> temp = result.poll();
                for (String word : current) {
                    String compare = temp.get(0);
                    if (diffByOne(word, compare)) {
                        List<String> nextList = new ArrayList<>(temp);
                        nextList.addFirst(word);
                        result.add(nextList);
                    }
                }
            }
        }

        return result;
    }

    public boolean bfs(String beginWord, String endWord, Map<String, Boolean> used, LinkedList<List<String>> layers) {
        if (!used.containsKey(endWord)) {
            return false;
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        used.put(beginWord, true);

        while (!queue.isEmpty()) {
            int size = queue.size();

            List<String> tempLayer = new ArrayList<>();

            for (int index = 0; index < size; index++) {
                String current = queue.poll();
                tempLayer.add(current);
                if (endWord.equals(current)) {
                    return true;
                }
                for (String word : used.keySet()) {
                    if (!used.get(word) && diffByOne(word, current)) {
                        used.put(word, true);
                        queue.add(word);
                    }
                }
            }
            layers.add(tempLayer);
        }

        return false;
    }

    public boolean diffByOne(String w1, String w2) {
        int count = 0;
        for (int index = 0; index < w1.length(); index++) {
            if (w1.charAt(index) != w2.charAt(index)) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return count == 1;
    }
}