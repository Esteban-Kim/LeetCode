class Solution {
    public int minAnagramLength(String s) {
        if (s.length() == 1) {
            return 1;
        }
        List<Integer> validLengths = new ArrayList<>();
        findValidLengths(s.length(), validLengths);
        Collections.sort(validLengths);

        for (int num : validLengths) {
            if (isValid(num, s)) {
                return num;
            }
        }

        return -1;
    }

    public boolean isValid(int size, String s) {
        // System.out.println(size);
        String target = s.substring(0, size);

        for (int index = size; index < s.length(); index += size) {
            String next = s.substring(index, index+size);
            if (!isSame(target, next)) {
                return false;
            }
        }

        return true;
    }

    public boolean isSame(String target, String other) {
        int[] t = new int[26];
        for (char c : target.toCharArray()) {
            t[c-'a']++;
        }
        for (char c : other.toCharArray()) {
            t[c-'a']--;
        }
        for (int num : t) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }

    public void findValidLengths(int n, List<Integer> validLengths) {
        int current = 1;

        while (current <= (n/2)) {
            if (n%current == 0) {
                validLengths.add(current);
                if (n/current != current) {
                    validLengths.add(n/current);
                }
            }
            current++;
        }
    }
}