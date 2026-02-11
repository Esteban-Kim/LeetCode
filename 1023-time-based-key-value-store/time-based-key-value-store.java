class TimeMap {
    Map<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>(); 
    }
    
    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> treeMap = map.getOrDefault(key, new TreeMap<>());
        treeMap.put(timestamp, value);
        map.put(key, treeMap);
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> treeMap = map.getOrDefault(key, new TreeMap<>());
        Integer floorKey = treeMap.floorKey(timestamp);
        return floorKey == null ? "" : treeMap.get(floorKey);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */