class Solution {
    public int minInsertions(String s) {
        Stack<Integer> stack = new Stack<>();
        int leftCount = 0, minimum = 0;
        
        for (int index = s.length()-1; index >= 0; index--) {
            char c = s.charAt(index);
            if (c == ')') {
                stack.push(index);
            } else {
                if (stack.isEmpty()) {
                    minimum += 2;
                } else {
                    if (stack.size() == 1) {
                        stack.pop();
                        minimum++;
                    } else {
                        int next = stack.pop();
                        if (!stack.isEmpty() && stack.peek() == next+1) {
                            stack.pop();
                        } else {
                            minimum++;
                        }
                    }
                }
            }
        }

        while (!stack.isEmpty()) {
            int next = stack.pop();
            if (!stack.isEmpty() && stack.peek()-1 == next) {
                stack.pop();
                minimum++;
            } else {
                minimum += 2;
            }
        }

        return minimum;
    }
}