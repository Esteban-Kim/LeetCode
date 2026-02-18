class Solution {
    public String alienOrder(String[] words) {
        // w -> e, e -> r, t -> f
        Map<Character, List<Character>> edges = new HashMap<>();
        Map<Character, Integer> indegrees = new HashMap<>();

        if (!findEdges(words, edges, indegrees)) {
            return "";
        }

        // Kahn's algorithm
        StringBuilder order = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();

        int size = indegrees.size();

        for (Map.Entry<Character, Integer> entry : indegrees.entrySet()) {
            if (entry.getValue() == 0) {
                queue.add(entry.getKey());
            }
        }

        while (!queue.isEmpty()) {
            Character next = queue.poll();
            order.append(next);
            List<Character> edge = edges.get(next);
            for (Character e : edge) {
                indegrees.put(e, indegrees.get(e)-1);
                if (indegrees.get(e) == 0) {
                    queue.add(e);
                }
            }
        }

        return size == order.length() ? order.toString() : "";
    }

    public boolean findEdges(String[] words, Map<Character, List<Character>> edges, Map<Character, Integer> indegrees) {
        for (String word : words) {
            for (char c : word.toCharArray()) {
                edges.putIfAbsent(c, new ArrayList<>());
                indegrees.putIfAbsent(c, 0);
            }
        }

        for (int index = 0; index < words.length-1; index++) {
            String word1 = words[index], word2 = words[index+1];
            // apple vs app
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return false;
            }
            for (int cIndex = 0; cIndex < Math.min(word1.length(), word2.length()); cIndex++) {
                char c1 = word1.charAt(cIndex), c2 = word2.charAt(cIndex);
                if (c1 != c2) {
                    edges.get(c1).add(c2);
                    indegrees.put(c2, indegrees.get(c2)+1);
                    break;
                }
            }
        }

        return true;
    }
}