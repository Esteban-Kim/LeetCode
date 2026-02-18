class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> left = new Stack<>();
        Stack<Integer> asterik = new Stack<>();

        for (int index = 0; index < s.length(); index++) {
            char c = s.charAt(index);
            if (c == '(') {
                left.push(index);
            } else if (c == '*') {
                asterik.push(index);
            } else {
                if (left.size() > 0) {
                    left.pop();
                } else if (asterik.size() > 0) {
                    asterik.pop();
                } else {
                    return false;
                }
            }
        }

        while (!left.isEmpty() && !asterik.isEmpty()) {
            if (left.peek() < asterik.peek()) {
                left.pop();
                asterik.pop();
            } else {
                return false;
            }
        }

        return left.isEmpty();
    }
}