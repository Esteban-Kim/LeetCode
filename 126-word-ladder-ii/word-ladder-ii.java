class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Map<String, Boolean> usedWordMap = new HashMap<>();
        for (String word : wordList) {
            usedWordMap.put(word, false);
        }
        List<Set<String>> ladders = new ArrayList<>();
        
        if (!bfs(beginWord, endWord, ladders, usedWordMap)) {
            return new ArrayList<>();
        }

        Queue<List<String>> queue = new LinkedList<>();
        queue.add(Arrays.asList(endWord));

        for (int index = ladders.size()-1; index >= 0; index--) {
            Set<String> ladder = ladders.get(index);
            int size = queue.size();
            for (int lIndex = 0; lIndex < size; lIndex++) {
                List<String> temp = queue.poll();
                for (String l : ladder) {
                    String compare = temp.get(0);
                    if (differsByOne(l, compare)) {
                        List<String> next = new ArrayList<>(temp);
                        next.addFirst(l);
                        queue.add(next);
                    }
                }
            }
        }

        return new ArrayList<>(queue);
    }

    public boolean bfs(String beginWord, String endWord, List<Set<String>> ladders, Map<String, Boolean> usedWordMap) {
        if (!usedWordMap.containsKey(endWord)) {
            return false;
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        usedWordMap.put(beginWord, true);

        while (!queue.isEmpty()) {
            int size = queue.size();
            Set<String> tempList = new HashSet<>();
            for (int index = 0; index < size; index++) {
                String next = queue.poll();
                if (next.equals(endWord)) {
                    return true;
                }
                tempList.add(next);
                for (Map.Entry<String, Boolean> entry : usedWordMap.entrySet()) {
                    if (!entry.getValue() && differsByOne(entry.getKey(), next)) {
                        queue.add(entry.getKey());
                        usedWordMap.put(entry.getKey(), true);
                    }
                }
            }
            ladders.add(tempList);
        }

        return false;
    }

    public boolean differsByOne(String w1, String w2) {
        int count = 0;
        for (int index = 0; index < w1.length(); index++) {
            if (w1.charAt(index) != w2.charAt(index)) {
                count++;
            }
        }
        return count == 1;
    }
}