class Solution {
    public int longestBeautifulSubstring(String word) {
        int count = 1, length = 1, maxLength = 0;

        for (int index = 1; index < word.length(); index++) {
            char first = word.charAt(index-1), second = word.charAt(index);
            if (first == second) {
                length++;
            } else if (first < second) {
                length++;
                count++;
            } else {
                count = 1;
                length = 1;
            }
            if (count == 5) {
                maxLength = Math.max(maxLength, length);
            }
        }

        return maxLength;
    }
}