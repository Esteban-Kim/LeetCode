class Solution {
    public boolean strongPasswordCheckerII(String password) {
        boolean containsLower = false, containsUpper = false, containsDigit = false, containsSpecialCharacter = false;
        int length = password.length();

        char lastCharacter = ' ';

        for (char c : password.toCharArray()) {
            if (lastCharacter == c) {
                return false;
            }
            lastCharacter = c;

            if (Character.isLowerCase(c)) {
                containsLower = true;
            } else if (Character.isUpperCase(c)) {
                containsUpper = true;
            } else if (Character.isDigit(c)) {
                containsDigit = true;
            } else if (isSpecialCharacter(c)) {
                containsSpecialCharacter = true;
            }
        }

        return length >= 8 && containsLower && containsUpper && containsDigit && containsSpecialCharacter;
    }

    public boolean isSpecialCharacter(char c) {
        String specialCharacters = "!@#$%^&*()-+";
        return specialCharacters.indexOf(c) != -1;
    }
}