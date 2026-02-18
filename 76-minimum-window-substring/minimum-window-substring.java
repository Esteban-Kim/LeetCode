class Solution {
    public String minWindow(String s, String t) {
        int left = 0, right = 0, sLength = s.length(), tLength = t.length();

        if (sLength < tLength) {
            return "";
        }

        Map<Character, Integer> target = new HashMap<>();

        for (char c : t.toCharArray()) {
            target.put(c, target.getOrDefault(c, 0)+1);
        }

        Map<Character, Integer> current = new HashMap<>();

        int minLength = Integer.MAX_VALUE;
        String answer = "";

        while (right < sLength) {
            char c = s.charAt(right++);
            current.put(c, current.getOrDefault(c, 0)+1);
            while (meetsTarget(current, target)) {
                if (right-left < minLength) {
                    minLength = right-left;
                    answer = s.substring(left, right);
                }
                char remove = s.charAt(left);
                current.put(remove, current.get(remove)-1);
                left++;
            }
        }

        return answer;
    }

    public boolean meetsTarget(Map<Character, Integer> current, Map<Character, Integer> target) {
        for (Map.Entry<Character, Integer> entry : target.entrySet()) {
            if (current.getOrDefault(entry.getKey(), 0)-entry.getValue() < 0) {
                return false;
            }
        }
        return true;
    }
}