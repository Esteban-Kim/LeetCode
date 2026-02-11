class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return a[0] == b[0] ? b[1]-a[1] : a[0]-b[0];
        });
        
        List<int[]> list = new ArrayList<>();
        int currentMin = intervals[0][0], currentMax = intervals[0][1];

        for (int index = 1; index < intervals.length; index++) {
            int[] next = intervals[index];
            int nextMin = next[0], nextMax = next[1];
            if (currentMax >= nextMax || currentMax >= nextMin) {
                currentMax = Math.max(currentMax, nextMax);
            } else {
                list.add(new int[]{currentMin, currentMax});
                currentMin = nextMin;
                currentMax = nextMax;
            }
        }

        list.add(new int[]{currentMin, currentMax});

        int[][] merged = new int[list.size()][2];
        int index = 0;

        for (int[] l : list) {
            merged[index++] = l;
        }

        return merged;
    }
}