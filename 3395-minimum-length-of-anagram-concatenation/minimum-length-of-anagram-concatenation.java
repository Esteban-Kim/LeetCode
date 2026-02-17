class Solution {
    public int minAnagramLength(String s) {
        List<Integer> validAnagramLengths = new ArrayList<>();

        findValidAnagramLengths(s.length(), validAnagramLengths);

        Collections.sort(validAnagramLengths);

        for (int length : validAnagramLengths) {
            String target = s.substring(0, length);
            boolean isValid = true;
            for (int index = length; index < s.length(); index += length) {
                if (!isSame(target, s.substring(index, index+length))) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                return length;
            }
        }

        return s.length();
    }

    public boolean isSame(String target, String next) {
        int[] frequency = new int[26];
        for (char c : target.toCharArray()) {
            frequency[c-'a']++;
        }
        for (char c : next.toCharArray()) {
            frequency[c-'a']--;
        }
        for (int num : frequency) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }

    public void findValidAnagramLengths(int n, List<Integer> validAnagramLengths) {
        int length = 1;
        Set<Integer> validLengths = new HashSet<>();

        while (length <= (n/2)) {
            if (n%length == 0) {
                validLengths.add(length);
                validLengths.add(n/length);
            }
            length++;
        }

        validAnagramLengths.addAll(validLengths);
    }
}