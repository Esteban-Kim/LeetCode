class Solution {
    public String minWindow(String s, String t) {
        int begIndex = 0, endIndex = 0, sLength = s.length();

        Map<Character, Integer> targetFrequency = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetFrequency.put(c, targetFrequency.getOrDefault(c, 0)+1);
        }

        Map<Character, Integer> sFrequency = new HashMap<>();

        String solution = "";
        int solutionLength = Integer.MAX_VALUE;
        
        /**
        step 1: increment endIndex until we find a solution
        Then we want to decrement begIndex as long as there is a solution
        If no solution exists then we continue back with step 1
         */
        while (endIndex < sLength) {
            char current = s.charAt(endIndex++);
            sFrequency.put(current, sFrequency.getOrDefault(current, 0)+1);
            // if (containsT(sFrequency, targetFrequency)) {
            //     int currentLength = endIndex-begIndex;
            //     if (solutionLength > currentLength) {
            //         solutionLength = Math.min(solutionLength, endIndex-begIndex);
            //         solution = s.substring(begIndex, endIndex);
            //     }
                
                while (containsT(sFrequency, targetFrequency)) {
                    int currentLength = endIndex-begIndex;
                    if (solutionLength > currentLength) {
                        solutionLength = Math.min(solutionLength, endIndex-begIndex);
                        solution = s.substring(begIndex, endIndex);
                    }
                    char begCharacter = s.charAt(begIndex++);
                    sFrequency.put(begCharacter, sFrequency.getOrDefault(begCharacter, 0)-1);
                }
            // }
        }

        return solution;
    }

    public boolean containsT(Map<Character, Integer> sFrequency, Map<Character, Integer> targetFrequency) {
        for (Map.Entry<Character, Integer> entry : targetFrequency.entrySet()) {
            if (sFrequency.getOrDefault(entry.getKey(), 0)-entry.getValue() < 0) {
                return false;
            }
        }

        return true;
    }
}