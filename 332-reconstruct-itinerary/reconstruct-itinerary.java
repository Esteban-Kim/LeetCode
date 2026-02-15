class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> paths = new HashMap<>();

        for (List<String> ticket : tickets) {
            String origin = ticket.get(0), destination = ticket.get(1);
            PriorityQueue<String> pQueue = paths.getOrDefault(origin, new PriorityQueue<>());
            pQueue.add(destination);
            paths.put(origin, pQueue);
        }

        List<String> itinerary = new ArrayList<>();

        dfs("JFK", paths, itinerary);

        return itinerary;
    }

    public void dfs(String airport, Map<String, PriorityQueue<String>> paths, List<String> itinerary) {
        PriorityQueue<String> pQueue = paths.getOrDefault(airport, new PriorityQueue<>());

        while (!pQueue.isEmpty()) {
            String nextAirport = pQueue.poll();
            dfs(nextAirport, paths, itinerary);
        }

        itinerary.addFirst(airport);
    }
}