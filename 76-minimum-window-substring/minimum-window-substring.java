class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tFrequency = new HashMap<>();
        for (char c : t.toCharArray()) {
            tFrequency.put(c, tFrequency.getOrDefault(c, 0)+1);
        }

        String minString = "";
        int minWindow = Integer.MAX_VALUE, left = 0, right = 0, length = s.length();

        Map<Character, Integer> sFrequency = new HashMap<>();

        while (right < length) {
            char c = s.charAt(right);
            sFrequency.put(c, sFrequency.getOrDefault(c, 0)+1);
            while (valid(tFrequency, sFrequency)) {
                int totalLength = right-left+1;
                if (totalLength < minWindow) {
                    minWindow = totalLength;
                    minString = s.substring(left, right+1);
                }
                char remove = s.charAt(left++);
                sFrequency.put(remove, sFrequency.get(remove)-1);
            }
            right++;
        }

        return minString;
    }

    public boolean valid(Map<Character, Integer> tFrequency, Map<Character, Integer> sFrequency) {
        for (Map.Entry<Character, Integer> entry : tFrequency.entrySet()) {
            if (entry.getValue() > sFrequency.getOrDefault(entry.getKey(), 0)) {
                return false;
            }
        }
        return true;
    }
}