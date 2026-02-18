class Solution {
    public int maxPalindromes(String s, int k) {
        List<List<Integer>> allPalindromes = new ArrayList<>();
        findPalindromes(s, k, allPalindromes);
        Collections.sort(allPalindromes, (a, b) -> a.get(0) == b.get(0) ? a.get(1)-b.get(1) : a.get(0)-b.get(0));

        int count = 0;

        if (allPalindromes.isEmpty()) {
            return count;
        }
        count++;
        int min = allPalindromes.get(0).get(1);

        for (int index = 1; index < allPalindromes.size(); index++) {
            int start = allPalindromes.get(index).get(0), end = allPalindromes.get(index).get(1);
            if (min <= start) {
                min = end;
                count++;
            }
        }

        return count;
    }

    public void findPalindromes(String s, int k, List<List<Integer>> all) {
        for (int index = 0; index < s.length(); index++) {
            if (index != 0) {
                even(s, k, all, index-1, index);
            }
            odd(s, k, all, index);
        }
    }

    public void even(String s, int k, List<List<Integer>> all, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            if (right-left+1 >= k) {
                all.add(Arrays.asList(left, right+1));
                break;
            }
            left--;
            right++;
        }
    }

    public void odd(String s, int k, List<List<Integer>> all, int index) {
        int left = index, right = index;

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            if (right-left+1 >= k) {
                all.add(Arrays.asList(left, right+1));
                break;
            }
            left--;
            right++;
        }
    }
}