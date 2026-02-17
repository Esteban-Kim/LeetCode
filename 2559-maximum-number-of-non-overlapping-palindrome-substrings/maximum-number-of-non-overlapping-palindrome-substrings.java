class Solution {
    public int maxPalindromes(String s, int k) {
        List<List<Integer>> palindromes = new ArrayList<>();
        findAllPalindromes(s, k, palindromes);
        Collections.sort(palindromes, (a, b) -> {
            return a.get(0) == b.get(0) ? a.get(1)-b.get(1) : a.get(0)-b.get(0);
        });

        int count = 0;

        if (palindromes.size() == 0) {
            return count;
        }

        System.out.println(palindromes.size());

        int min = palindromes.get(0).get(1);
        count++;

        for (int index = 1; index < palindromes.size(); index++) {
            if (min < palindromes.get(index).get(0)) {
                min = palindromes.get(index).get(1);
                count++;
            }
        }

        return count;
    }

    public void findAllPalindromes(String s, int k, List<List<Integer>> palindromes) {
        for (int index = 0; index < s.length(); index++) {
            if (index > 0) {
                evenPalindromes(s, k, index-1, index, palindromes);
            }
            oddPalindromes(s, k, index, palindromes);
        }
    }

    public void oddPalindromes(String s, int k, int index, List<List<Integer>> palindromes) {
        int left = index, right = index;

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            if (right-left+1 >= k) {
                palindromes.add(Arrays.asList(left, right));
                break;
            }
            left--;
            right++;
        }
    }

    public void evenPalindromes(String s, int k, int left, int right, List<List<Integer>> palindromes) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            if (right-left+1 >= k) {
                palindromes.add(Arrays.asList(left, right));
                break;
            }
            left--;
            right++;
        }
    }
}