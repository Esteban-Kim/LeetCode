class Solution {
    public String alienOrder(String[] words) {
        Map<Character, List<Character>> edges = new HashMap<>();
        Map<Character, Integer> indegrees = new HashMap<>();
        if (!find(words, edges, indegrees)) return "";

        StringBuilder temp = new StringBuilder();
        Queue<Character> order = new LinkedList<>();

        for (Map.Entry<Character, Integer> entry : indegrees.entrySet()) {
            if (entry.getValue() == 0) {
                order.add(entry.getKey());
            }
        }

        while (!order.isEmpty()) {
            Character next = order.poll();
            temp.append(next);
            List<Character> temp1 = edges.get(next);
            for (Character c : temp1) {
                indegrees.put(c, indegrees.get(c)-1);
                if (indegrees.get(c) == 0) {
                    order.add(c);
                }
            }
        }

        return temp.length() == indegrees.size() ? temp.toString() : "";
    }

    public boolean find(String[] words, Map<Character, List<Character>> edges, Map<Character, Integer> indegrees) {
        for (String word : words) {
            for (char c : word.toCharArray()) {
                edges.putIfAbsent(c, new ArrayList<>());
                indegrees.putIfAbsent(c, 0);
            }
        }
        for (int index = 0; index < words.length-1; index++) {
            String first = words[index], second = words[index+1];
            if (first.length() > second.length() && first.startsWith(second)) {
                return false;
            }
            for (int j = 0; j < Math.min(first.length(), second.length()); j++) {
                if (first.charAt(j) != second.charAt(j)) {
                    indegrees.put(second.charAt(j), indegrees.getOrDefault(second.charAt(j), 0)+1);
                    List<Character> temp = edges.getOrDefault(first.charAt(j), new ArrayList<>());
                    temp.add(second.charAt(j));
                    edges.put(first.charAt(j), temp);
                    break;
                }
            }
        }
        return true;
    }
}