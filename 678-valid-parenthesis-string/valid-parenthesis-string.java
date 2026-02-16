class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> lefts = new Stack<>();
        Stack<Integer> asteriks = new Stack<>();

        for (int index = 0; index < s.length(); index++) {
            char c = s.charAt(index);
            if (c == '(') {
                lefts.push(index);
            } else if (c == '*') {
                asteriks.push(index);
            } else {
                if (!lefts.isEmpty()) {
                    lefts.pop();
                } else if (!asteriks.isEmpty()) {
                    asteriks.pop();
                } else {
                    return false;
                }
            }
        }

        while (!lefts.isEmpty() && !asteriks.isEmpty()) {
            if (lefts.peek() > asteriks.peek()) {
                return false;
            }
            lefts.pop();
            asteriks.pop();
        }

        return lefts.isEmpty();
    }
}