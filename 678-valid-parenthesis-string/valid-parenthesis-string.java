class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> leftBracket = new Stack<>();
        Stack<Integer> asterikBracket = new Stack<>();

        for (int index = 0; index < s.length(); index++) {
            char c = s.charAt(index);
            if (c == '(') {
                leftBracket.push(index);
            } else if (c == '*') {
                asterikBracket.push(index);
            } else {
                if (!leftBracket.isEmpty()) {
                    leftBracket.pop();
                } else if (!asterikBracket.isEmpty()) {
                    asterikBracket.pop();
                } else {
                    return false;
                }
            }
        }

        while (!leftBracket.isEmpty() && !asterikBracket.isEmpty()) {
            if (leftBracket.peek() < asterikBracket.peek()) {
                leftBracket.pop();
                asterikBracket.pop();
            } else {
                return false;
            }
        }

        return leftBracket.isEmpty();
    }
}