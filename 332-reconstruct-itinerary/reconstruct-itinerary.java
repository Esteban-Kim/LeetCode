class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> path = new ArrayList<>();
        Map<String, PriorityQueue<String>> map = new HashMap<>();

        for (List<String> ticket : tickets) {
            String start = ticket.get(0), end = ticket.get(1);
            PriorityQueue<String> temp = map.getOrDefault(start, new PriorityQueue<>());
            temp.add(end);
            map.put(start, temp);
        }

        dfs("JFK", map, path);

        return path;
    }

    public void dfs(String airport, Map<String, PriorityQueue<String>> map, List<String> path) {
        PriorityQueue<String> pQueue = map.getOrDefault(airport, new PriorityQueue<>());

        while (!pQueue.isEmpty()) {
            String next = pQueue.poll();
            dfs(next, map, path);
        }

        path.addFirst(airport);
    }
}