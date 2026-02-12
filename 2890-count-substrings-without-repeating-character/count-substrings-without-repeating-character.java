class Solution {
    public int numberOfSpecialSubstrings(String s) {
        int count = 0, begIndex = 0, endIndex = 0, length = s.length();
        Set<Character> used = new HashSet<>();

        while (endIndex < length) {
            char c = s.charAt(endIndex++);
            while (used.contains(c)) {
                used.remove(s.charAt(begIndex++));
            }
            used.add(c);
            count += used.size();
        }

        return count;
    }
}