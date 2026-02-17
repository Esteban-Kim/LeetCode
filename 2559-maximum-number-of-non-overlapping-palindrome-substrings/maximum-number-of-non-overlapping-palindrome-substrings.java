class Solution {
    public int maxPalindromes(String s, int k) {
        List<List<Integer>> palindromes = new ArrayList<>();

        for (int index = 0; index < s.length(); index++) {
            if (index != 0) {
                evenPalindrome(s, index-1, index, k, palindromes);
            }
            oddPalindrome(s, index, k, palindromes);
        }

        Collections.sort(palindromes, (a, b) -> {
            return a.get(0) == b.get(0) ? a.get(1)-b.get(1) : a.get(0)-b.get(0);
        });

        int maxNumber = 0;

        if (palindromes.isEmpty()) {
            return maxNumber;
        }

        maxNumber++;
        int previousEnd = palindromes.get(0).get(1);

        for (int index = 1; index < palindromes.size(); index++) {
            int start = palindromes.get(index).get(0), end = palindromes.get(index).get(1);
            if (previousEnd <= start) {
                previousEnd = end;
                maxNumber++;
            }
        }

        return maxNumber;
    }

    public void evenPalindrome(String s, int left, int right, int k, List<List<Integer>> palindromes) {
        int length = s.length();

        while (left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
            if (right-left+1 >= k) {
                palindromes.add(Arrays.asList(left, right+1));
                break;
            }
            left--;
            right++;
        }
    }

    public void oddPalindrome(String s, int index, int k, List<List<Integer>> palindromes) {
        int left = index, right = index, length = s.length();

        while (left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
            if (right-left+1 >= k) {
                palindromes.add(Arrays.asList(left, right+1));
                break;
            }
            left--;
            right++;
        }
    }
}