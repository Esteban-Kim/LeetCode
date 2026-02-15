class Solution {
    public int longestBeautifulSubstring(String word) {
        int count = 1;
        int length = 1;
        int maxLength = 0;

        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i-1) == word.charAt(i)) {
                length++;
            } else if (word.charAt(i-1) < word.charAt(i)) {
                count++;
                length++;
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