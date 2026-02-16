class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> sFrequency = new HashMap<>();
        Map<Character, Integer> tFrequency = new HashMap<>();

        for (char c : t.toCharArray()) {
            tFrequency.put(c, tFrequency.getOrDefault(c, 0)+1);
        }

        int minWindow = Integer.MAX_VALUE, left = 0, right = 0, length = s.length();
        String minString = "";

        while (right < length) {
            char c = s.charAt(right++);
            sFrequency.put(c, sFrequency.getOrDefault(c, 0)+1);
            if (isValid(tFrequency, sFrequency)) {
                if (right-left < minWindow) {
                    minWindow = right-left;
                    minString = s.substring(left, right);
                }

                char r = s.charAt(left++);
                sFrequency.put(r, sFrequency.getOrDefault(r, 0)-1);

                while (isValid(tFrequency, sFrequency)) {
                    if (right-left < minWindow) {
                        minWindow = right-left;
                        minString = s.substring(left, right);
                    }
                    r = s.charAt(left++);
                    sFrequency.put(r, sFrequency.getOrDefault(r, 0)-1);
                }
            }
        }

        return minString;
    }

    public boolean isValid(Map<Character, Integer> tFrequency, Map<Character, Integer> sFrequency) {
        for (Map.Entry<Character, Integer> entry : tFrequency.entrySet()) {
            if (entry.getValue()-sFrequency.getOrDefault(entry.getKey(), 0) > 0) {
                return false;
            }
        }
        return true;
    }
}