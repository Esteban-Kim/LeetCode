class Solution {
    public String alienOrder(String[] words) {
        Map<Character, List<Character>> edges = new HashMap<>();
        Map<Character, Integer> inwards = new HashMap<>();

        if (!generateEdges(words, edges, inwards)) {
            return "";
        }

        int size = inwards.size();
        Queue<Character> queue = new LinkedList<>();

        for (Map.Entry<Character, Integer> entry : inwards.entrySet()) {
            if (entry.getValue() == 0) {
                queue.add(entry.getKey());
            }
        }

        StringBuilder answer = new StringBuilder();


        while (!queue.isEmpty()) {
            Character next = queue.poll();
            answer.append(next);
            List<Character> adjacent = edges.getOrDefault(next, new ArrayList<>());
            for (Character t : adjacent) {
                inwards.put(t, inwards.get(t)-1);
                if (inwards.get(t) == 0) {
                    queue.add(t);
                }
            }
        }

        if (size != answer.length()) {
            return "";
        }

        return answer.toString();
    }

    public boolean generateEdges(String[] words, Map<Character, List<Character>> edges, Map<Character, Integer> inwards) {
        int length = words.length;

        for (String word : words) {
            for (char c : word.toCharArray()) {
                edges.putIfAbsent(c, new ArrayList<>());
                inwards.putIfAbsent(c, 0);
            }
        }

        for (int index = 0; index < length-1; index++) {
            String first = words[index];
            String second = words[index+1];
            
            if (first.length() > second.length() && first.startsWith(second)) {
                return false;
            }
            for (int j = 0; j < Math.min(first.length(), second.length()); j++) {
                if (first.charAt(j) != second.charAt(j)) {
                    List<Character> temp = edges.getOrDefault(first.charAt(j), new ArrayList<>());
                    temp.add(second.charAt(j));
                    edges.put(first.charAt(j), temp);
                    inwards.put(second.charAt(j), inwards.getOrDefault(second.charAt(j), 0)+1);
                    break;
                }
            }
        }

        return true;
    }
}