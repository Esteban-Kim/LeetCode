class Solution {
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        String result = helper(num%1000);
        num /= 1000;
        if (num > 0 && num%1000 > 0) {
            result = helper(num%1000) + " Thousand " + result;
        }
        num /= 1000;
        if (num > 0 && num%1000 > 0) {
            result = helper(num%1000) + " Million " + result;
        }
        num /= 1000;
        if (num > 0) {
            result = helper(num%1000) + " Billion " + result;
        }
        return result.trim();
    }

    public String helper(int num) {
        String[] digit = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String result = "";

        if (num > 99) {
            result += digit[num/100] + " Hundred ";
        }
        num = num % 100;
        if (num > 9 && num < 20) {
            result += teens[num%10] + " ";
        } else {
            if (num > 19) {
                result += tens[num/10] + " ";
            }
            num = num % 10;
            if (num > 0) {
                result += digit[num] + " ";
            }
        }

        return result.trim();
    }
}