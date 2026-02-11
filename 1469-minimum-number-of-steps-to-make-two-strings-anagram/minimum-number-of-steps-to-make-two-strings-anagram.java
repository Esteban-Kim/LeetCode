class Solution {
    public int minSteps(String s, String t) {
        int[] sFrequency = new int[26], tFrequency = new int[26];

        for (char c : s.toCharArray()) {
            sFrequency[c-'a']++;
        }
        for (char c : t.toCharArray()) {
            tFrequency[c-'a']++;
        }

        return moves(sFrequency, tFrequency);
    }

    public int moves(int[] sFrequency, int[] tFrequency) {
        int moves = 0;

        for (int index = 0; index < 26; index++) {
            moves += Math.abs(sFrequency[index]-tFrequency[index]);
        }

        return moves/2;
    }
}