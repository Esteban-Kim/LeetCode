class RandomizedSet {
    Map<Integer, Integer> valueToIndexMap;
    List<Integer> values;
    Random random;

    public RandomizedSet() {
        valueToIndexMap = new HashMap<>();
        values = new ArrayList<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if (valueToIndexMap.containsKey(val)) {
            return false;
        }
        valueToIndexMap.put(val, values.size());
        values.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if (!valueToIndexMap.containsKey(val)) {
            return false;
        }

        int lastValue = values.get(values.size()-1);
        int valIndex = valueToIndexMap.get(val);

        values.set(valIndex, lastValue);
        values.removeLast();

        valueToIndexMap.put(lastValue, valIndex);
        valueToIndexMap.remove(val);

        return true;
    }
    
    public int getRandom() {
        return values.get(random.nextInt(values.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */